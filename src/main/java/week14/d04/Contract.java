package week14.d04;

import java.util.List;

public class Contract {

    private final String client;
    private final List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

}
