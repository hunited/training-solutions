package week13.d04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {

    public String merge(Path file, List<Employee> employees) {
        try (InputStream is = TemplateMerger.class.getResourceAsStream(file.getFileName().toString());
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addEmployee(employees, line);
            }
            return toStringLines(employees);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    private void addEmployee(List<Employee> employees, String line) {
        String[] data = line.split(":");
        String name = data[1].trim().substring(0, data[1].indexOf(','));
        int year = Integer.parseInt(data[2].trim());
        employees.add(new Employee(name, year));
    }

    private String toStringLines(List<Employee> employees) {
        if (employees.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < employees.size(); i++) {
            sb.append(employees.get(i).toString());
            if (i != employees.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

}
