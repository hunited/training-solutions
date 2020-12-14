package week07.d05S;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SaveInput {

    Scanner scanner;

    public SaveInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.println("Írd be az " + (i + 1) + ". sort!");
            lines.add(scanner.nextLine());
        }
        return lines;
    }

    public Path readFileName() {
        System.out.println("Mi legyen a fájl neve?");
        String file = scanner.nextLine();
        return Path.of(file);
    }

    public boolean fileWriter(List<String> lines) {
        try {
            Files.write(readFileName(), lines);
            System.out.println("Sikeres mentés!");
            return true;
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Nem írható a fájl: " + ioe);
        }
    }

}
