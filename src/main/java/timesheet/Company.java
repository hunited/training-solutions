package timesheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Company {

    private final List<Employee> employees = new ArrayList<>();
    private final List<Project> projects = new ArrayList<>();
    private final List<TimeSheetItem> timeSheetItems = new ArrayList<>();

    public Company(InputStream employeesFile, InputStream projectsFile) {
        employeeGenerator(employeesFile);
        projectGenerator(projectsFile);
    }

    public void addTimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        TimeSheetItem tsi = new TimeSheetItem(employee, project, beginDate, endDate);
        timeSheetItems.add(tsi);
    }

    public List<ReportLine> calculateProjectByNameYearMonth(String employeeName, int year, int month) {
        foundEmployee(employeeName);
        Map<String, Integer> pairs = new HashMap<>();
        List<ReportLine> reportLines = getReports(pairs);
        for (TimeSheetItem timeSheetItem : getTimeSheetItems(employeeName, year, month)) {
            String pName = timeSheetItem.getProject().getName();
            reportLines.get(pairs.get(pName)).addTime(timeSheetItem.hoursBetweenDates());
        }
        return reportLines;
    }

    public void printToFile(String employeeName, int year, int month, Path file) {
        StringBuilder printLine = new StringBuilder(employeeName + "\t" + year + "-" + String.format("%02d", month) + "\t");
        int employeeHours = 0;
        List<ReportLine> reportLines;
        reportLines = calculateProjectByNameYearMonth(employeeName, year, month);
        for (ReportLine reportLine : reportLines) {
            employeeHours += reportLine.getTime();
        }
        printLine.append(employeeHours).append("\n");
        for (ReportLine reportLine : reportLines) {
            if (reportLine.getTime() != 0) {
                printLine.append(reportLine.getProject().getName()).append("\t").append(reportLine.getTime()).append("\n");
            }
        }
        fileWriter(file, printLine);
    }

    private void employeeGenerator(InputStream employeesFile) {
        try (BufferedReader employeeReader = new BufferedReader(new InputStreamReader(employeesFile))) {
            String line;
            while ((line = employeeReader.readLine()) != null) {
                String[] splitter = line.split(" ");
                employees.add(new Employee(splitter[0], splitter[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void projectGenerator(InputStream projectsFile) {
        try (BufferedReader projectReader = new BufferedReader(new InputStreamReader(projectsFile))) {
            String line;
            while ((line = projectReader.readLine()) != null) {
                projects.add(new Project(line));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void foundEmployee(String employeeName) {
        for (Employee employee : employees) {
            if (employee.getName().equals(employeeName)) {
                return;
            }
        }
        throw new IllegalArgumentException("No employee found");
    }

    private List<ReportLine> getReports(Map<String, Integer> pairs) {
        List<ReportLine> reportLines = new ArrayList<>();
        int i = 0;
        for (Project project : projects) {
            reportLines.add(new ReportLine(project, 0L));
            pairs.put(project.getName(), i++);
        }
        return reportLines;
    }

    private List<TimeSheetItem> getTimeSheetItems(String employeeName, int year, int month) {
        List<TimeSheetItem> filter;
        filter = timeSheetItems.stream().filter(timeSheetItem ->
                timeSheetItem.getEmployee().getName().equals(employeeName) &&
                        timeSheetItem.getBeginDate().getYear() == year &&
                        timeSheetItem.getBeginDate().getMonthValue() == month).collect(Collectors.toList()
        );
        return filter;
    }

    private void fileWriter(Path file, StringBuilder printLine) {
        try {
            Files.writeString(file, printLine.toString());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write");
        }
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public List<Project> getProjects() {
        return new ArrayList<>(projects);
    }

    public List<TimeSheetItem> getTimeSheetItems() {
        return timeSheetItems;
    }

}
