package lambdacomparator.cloud;

public class CloudStorage implements Comparable<CloudStorage> {

    private static final int SIZE = 1000;
    private static final int YEAR = 12;

    private final String provider;
    private final int space;
    private PayPeriod period;
    private double price;

    public CloudStorage(String provider, int space, PayPeriod period, double price) {
        this(provider, space);
        this.period = period;
        this.price = price;
    }

    public CloudStorage(String provider, int space) {
        this.provider = provider;
        this.space = space;
    }

    public String getProvider() {
        return provider;
    }

    public int getSpace() {
        return space;
    }

    public double getPrice() {
        return price;
    }

    public PayPeriod getPeriod() {
        return period;
    }

    @Override
    public int compareTo(CloudStorage o) {
        double currentValue = this.period != null ? this.price * YEAR / this.period.getLength() / this.space * SIZE : 0;
        double otherValue = o.period != null ? o.price * YEAR / o.period.getLength() / o.space * SIZE : 0;
        return Double.compare(currentValue, otherValue);
    }

}
