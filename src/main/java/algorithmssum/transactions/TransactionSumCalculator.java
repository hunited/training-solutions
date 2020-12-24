package algorithmssum.transactions;

import java.util.List;

public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions) {
        int sum = 0;
        for (Transaction transaction : transactions) {
            sum += transaction.isCredit() ? transaction.getAmount() : 0;
        }
        return sum;
    }

}
