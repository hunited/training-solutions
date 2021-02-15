package week16.d01;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CanoeRental {

    private final String name;
    private final CanoeType canoeType;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;

    public CanoeRental(String name, CanoeType canoeType, LocalDateTime startTime) {
        this.name = name;
        this.canoeType = canoeType;
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public double calculateRentalSum() {
        double result = ChronoUnit.MINUTES.between(startTime, endTime);
        return Math.ceil(result / 60);
    }

    public String getName() {
        return name;
    }

    public CanoeType getCanoeType() {
        return canoeType;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

}
