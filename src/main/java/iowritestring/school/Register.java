package iowritestring.school;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Register {

    public void newMark(Path name, int mark) {
        try {
            if (Files.exists(name)) {
                Files.writeString(
                        name, mark + "\n",
                        StandardCharsets.UTF_8, StandardOpenOption.APPEND
                );
            } else {
                Files.writeString(name, Integer.toString(mark), StandardCharsets.UTF_8);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("A fájl nem elérhető", ioe);
        }
    }

    public void average(Path name) {
        List<String> marks;
        try {
            marks = Files.readAllLines(name, StandardCharsets.UTF_8);
            double sum = 0;
            for (String mark : marks) {
                sum += Double.parseDouble(mark);
            }
            Files.writeString(
                    name, "average: " + (sum / marks.size()),
                    StandardCharsets.UTF_8, StandardOpenOption.APPEND
            );
        } catch (IOException ioe) {
            throw new IllegalStateException("A fájl nem elérhető", ioe);
        }
    }

}
