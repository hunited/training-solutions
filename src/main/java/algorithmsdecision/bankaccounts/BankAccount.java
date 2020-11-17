package algorithmsdecision.bankaccounts;

public class BankAccount {

    private String nameOfOwner;

    private String accountNumber;

    private int balance;

    public BankAccount(String nameOfOwner, String accountNumber, int balance) {
        this.nameOfOwner = nameOfOwner;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public boolean withdraw(int amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int amount) {
        balance += amount;
        return true;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

}
