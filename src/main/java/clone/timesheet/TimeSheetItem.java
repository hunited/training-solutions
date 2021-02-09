package clone.timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private String employee;
    private String project;
    private LocalDateTime from;
    private LocalDateTime to;

    public TimeSheetItem(String employee, String project, LocalDateTime from, LocalDateTime to) {
        this.employee = employee;
        this.project = project;
        this.from = from;
        this.to = to;
    }

    public TimeSheetItem(TimeSheetItem otherTimeSet) {
        employee = otherTimeSet.employee;
        project = otherTimeSet.project;
        from = otherTimeSet.from;
        to = otherTimeSet.to;
    }

    public static TimeSheetItem withDifferentDay(TimeSheetItem otherTimeSet, LocalDate time) {
        TimeSheetItem result = new TimeSheetItem(otherTimeSet);
        result.from = LocalDateTime.of(time, result.from.toLocalTime());
        result.to = LocalDateTime.of(time, result.to.toLocalTime());
        return result;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

}
