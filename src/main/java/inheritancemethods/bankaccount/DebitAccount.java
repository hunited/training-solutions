package inheritancemethods.bankaccount;

public class DebitAccount {

    private static final double COST = 3.0;
    private static final long MIN_COST = 200;

    private String accountNumber;
    private long balance;

    public DebitAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public final long costOfTransaction(long amount) {
        long cost = (long) (amount * COST / 100);
        if (cost > MIN_COST) {
            return cost;
        }
        return MIN_COST;
    }

    public boolean transaction(long amount) {
        long value = amount + costOfTransaction(amount);
        if (value <= balance) {
            balance -= value;
            return true;
        }
        return false;
    }

    public void balanceToZero() {
        balance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }

}
