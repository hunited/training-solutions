package iodatastream.bank;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BankAccountManager {

    public void saveAccount(BankAccount bankAccount, Path dir) {
        Path path = dir.resolve(bankAccount.getAccountNumber() + ".dat");
        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            os.writeUTF(bankAccount.getAccountNumber());
            os.writeUTF(bankAccount.getOwner());
            os.writeDouble(bankAccount.getBalance());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    public BankAccount loadAccount(InputStream is) {
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(is))) {
            String accountNumber = dis.readUTF();
            String owner = dis.readUTF();
            double balance = dis.readDouble();
            return new BankAccount(accountNumber, owner, balance);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
