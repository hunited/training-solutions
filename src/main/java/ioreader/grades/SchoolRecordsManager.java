package ioreader.grades;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SchoolRecordsManager {

    private final List<Student> students = new ArrayList<>();

    public void readGradesFromFile(String fileName) {
        Path file = Path.of("src/main/resources/" + fileName);
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String content;
            while ((content = reader.readLine()) != null) {
                String[] line = content.split(" ");
                students.add(new Student(line[0], getGrades(line)));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public double classAverage() {
        double sum = 0.0;
        for (Student student : students) {
            sum += student.average();
        }
        return sum / students.size();
    }

    private List<Integer> getGrades(String[] line) {
        List<Integer> grades = new ArrayList<>();
        for (int i = 1; i < line.length; i++) {
            grades.add(Integer.parseInt(line[i]));
        }
        return grades;
    }

    public List<Student> getStudents() {
        return new ArrayList<>(students);
    }

}
