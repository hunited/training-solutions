package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecutor {

    public void executeTransactions(List<Transaction> transactions, List<BankAccount> bankAccounts) {
        for (Transaction transaction : transactions) {
            BankAccount bankAccount = findBankAccount(bankAccounts, transaction.getAccountNumber());
            if (bankAccount != null) {
                executeTransaction(transaction, bankAccount);
            } else {
                transaction.setNotExecutedSuccessfully();
            }
        }
    }

    private void executeTransaction(Transaction transaction, BankAccount bankAccount) {
        if (transaction.isCredit()) {
            bankAccount.deposit(transaction.getAmount());
            transaction.setExecutedSuccessfully();
        } else {
            if (bankAccount.withdraw(transaction.getAmount())) {
                transaction.setExecutedSuccessfully();
            } else {
                transaction.setNotExecutedSuccessfully();
            }
        }
    }

    private BankAccount findBankAccount(List<BankAccount> accounts, String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

}
