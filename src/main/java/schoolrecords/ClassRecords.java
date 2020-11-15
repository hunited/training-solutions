package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;

    private Random rnd;

    List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        boolean found = false;
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                found = true;
                break;
            }
        }
        if (!found) {
            students.add(student);
        }
        return found;
    }

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double studensSum = 0.0;
        int studentNum = 0;
        for (Student student : students) {
            if (student.calculateAverage() > 0) {
                studensSum += student.calculateAverage();
                studentNum++;
            }
        }
        return Math.round((studensSum / studentNum) * 100) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        double studensSum = 0.0;
        int studentNum = 0;
        for (Student student : students) {
            if (student.calculateSubjectAverage(subject) > 0) {
                studensSum += student.calculateSubjectAverage(subject);
                studentNum++;
            }
        }
        return Math.round((studensSum / studentNum) * 100) / 100.0;
    }

    public Student findStudentByName(String name) {
        Student foundStudent = null;
        for (Student student : students) {
            if (name.equals(student.getName())) {
                foundStudent = student;
                break;
            }
        }
        return foundStudent;
    }

    public String listStudentNames() {
        String names = "";
        for (Student student : students) {
            names += student.getName() + ", ";
        }
        return names.substring(0, names.length() - 2);
    }

    public List<StudyResultByName> listStudyResults() {
        List<StudyResultByName> studyResultByNames = new ArrayList<>();
        for (Student student : students) {
            studyResultByNames.add(new StudyResultByName(student.calculateAverage(), student.getName()));
        }
        return studyResultByNames;
    }

    public boolean removeStudent(Student student) {
        boolean found = false;
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                found = true;
                students.remove(student1);
                break;
            }
        }
        return found;
    }

    public Student repetition() {
        return students.get(rnd.nextInt(students.size()));
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
