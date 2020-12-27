package inheritancemethods.bankaccount;

public class CreditAccount extends DebitAccount {

    private long overdraftLimit;

    public CreditAccount(String accountNumber, long balance, long overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean transaction(long amount) {
        long value = amount + costOfTransaction(amount);
        if (value > getBalance() + overdraftLimit) {
            return false;
        }
        if (value <= getBalance()) {
             super.transaction(amount);
        } else {
            long temp = amount - getBalance();
            balanceToZero();
            overdraftLimit -= temp + costOfTransaction(amount);
        }
        return true;
    }

    public long getOverdraftLimit() {
        return overdraftLimit;
    }

}
