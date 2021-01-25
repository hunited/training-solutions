package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {

    private final List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(file))) {
            for (String name : names) {
                writer.println(name + ": " + getPayment(name));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not write file", ioe);
        }
    }

    private int getPayment(String name) {
        if (name.contains("Dr")) {
            return 500000;
        } else if (name.contains("Mr") || name.contains("Mrs")) {
            return 200000;
        }
        return 100000;
    }

}
