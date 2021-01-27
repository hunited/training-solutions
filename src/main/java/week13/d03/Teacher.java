package week13.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Teacher {

    public int teacherHour(String name) {
        try (InputStream is = Teacher.class.getResourceAsStream("beosztas.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            String line;
            int piece = 0;
            while ((line = reader.readLine()) != null) {
                if (line.contains(name)) {
                    reader.readLine();
                    reader.readLine();
                    piece += Integer.parseInt(reader.readLine());
                }
            }
            if (piece == 0){
                throw new IllegalArgumentException("Teacher not found");
            }
            return piece;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file!", ioe);
        }
    }

}
