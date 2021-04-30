package lambdaintermediate;

import java.time.LocalDateTime;
import java.util.List;

public class CoffeeOrder {

    private final List<Coffee> coffeeList;
    private final LocalDateTime dateTime;

    public CoffeeOrder(List<Coffee> coffeeList, LocalDateTime dateTime) {
        this.coffeeList = coffeeList;
        this.dateTime = dateTime;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
