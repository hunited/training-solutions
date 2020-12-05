package initializer.initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> RATES = new ArrayList<>();
    private long balance;

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        RATES.addAll(rates);
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public boolean payment(long amount, Currency currency) {
        long temp = Math.round(amount * getConversionRate(currency));
        if (temp <= balance) {
            balance -= temp;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

    public long getBalance() {
        return balance;
    }

    private double getConversionRate(Currency currency) {
        for (Rate rate : RATES) {
            if (rate.getCurrency() == currency) {
                return rate.getConversionFactor();
            }
        }
        return 1.0;
    }

}
