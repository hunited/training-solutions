package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> ba, int value) {
        int count = 0;
        for (BankAccount account : ba) {
            if (account.getBalance() > value) {
                count++;
            }
        }
        return count;
    }

}
