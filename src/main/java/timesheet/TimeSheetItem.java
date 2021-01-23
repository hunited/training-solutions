package timesheet;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeSheetItem {

    private final Employee employee;
    private final Project project;
    private final LocalDateTime beginDate;
    private final LocalDateTime endDate;

    public TimeSheetItem(Employee employee, Project project, LocalDateTime beginDate, LocalDateTime endDate) {
        if (beginDate.isAfter(endDate) || !beginDate.toLocalDate().equals(endDate.toLocalDate())) {
            throw new IllegalArgumentException("Wrong date");
        }
        this.employee = employee;
        this.project = project;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Project getProject() {
        return project;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public long hoursBetweenDates() {
        return Duration.between(beginDate, endDate).toHours();
    }

}
