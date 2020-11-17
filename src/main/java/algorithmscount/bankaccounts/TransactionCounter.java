package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactions, int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < amount) {
                count++;
            }
        }
        return count;
    }

}
