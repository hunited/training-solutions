package ioreadstring.transaction;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private final List<BankAccount> accountList = new ArrayList<>();

    public void uploadListFromFile(String path) {
        Path accounts = Path.of(path);
        try {
            List<String > bankAccounts = Files.readAllLines(accounts, StandardCharsets.UTF_8);
            for (String bankAccount : bankAccounts) {
                String[] row = bankAccount.split(";");
                BankAccount ba = new BankAccount(row[0], row[1], Integer.parseInt(row[2]));
                accountList.add(ba);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public void makeTransactions(String path) {
        Path transactions = Path.of(path);
        try {
            List<String > transactionsFile = Files.readAllLines(transactions, StandardCharsets.UTF_8);
            for (String transaction : transactionsFile) {
                String[] row = transaction.split(";");
                for (BankAccount account : accountList) {
                    if (row[0].equals(account.getAccountNumber())) {
                        account.setBalance(Integer.parseInt(row[1]));
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

}
