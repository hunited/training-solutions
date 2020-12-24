package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactions, LocalDateTime startTime, LocalDateTime endTime, int amount) {
        for (Transaction transaction : transactions) {
            if (transaction.isDebit() &&
                    transaction.getDateOfTransaction().isAfter(startTime) &&
                    transaction.getDateOfTransaction().isBefore(endTime) &&
                    transaction.getAmount() > amount) {
                return true;
            }
        }
        return false;
    }

}
