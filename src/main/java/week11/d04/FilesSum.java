package week11.d04;

import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {

    public int sumNumbers() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            String fileName = String.format("number%02d.txt", i);
            if (Files.isRegularFile(Path.of(fileName))) {
                int content = Integer.parseInt(fileName.substring(6, 8));
                if (content >= 0 && content < 100) {
                    sum += content;
                } else {
                    throw new IllegalArgumentException("Nem megfelelő fájlnév!");
                }
            }
        }
        return sum;
    }

}
