package lambdaintermediate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {

    private final List<CoffeeOrder> orders;

    public Cafe() {
        orders = new ArrayList<>();
    }

    public Cafe(List<CoffeeOrder> orders) {
        this.orders = orders;
    }

    public void addOrder(CoffeeOrder order) {
        orders.add(order);
    }

    public BigDecimal getTotalIncome() {
        return orders.stream()
                .flatMap(o -> o.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotalIncome(LocalDate date) {
        return orders.stream()
                .filter(order -> order.getDateTime().toLocalDate().equals(date))
                .flatMap(o -> o.getCoffeeList().stream())
                .map(Coffee::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return orders.stream()
                .flatMap(x -> x.getCoffeeList().stream())
                .map(Coffee::getType)
                .filter(type::equals)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from){
        return orders.stream()
                .filter(x -> x.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return orders.stream()
                .filter(x -> x.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }

}
