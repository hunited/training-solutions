package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;

    private Random rnd;

    List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        if (isEmpty(className)) {
            throw new IllegalArgumentException("Class name must not be empty");
        }
        this.className = className;
        this.rnd = rnd;
    }

    public boolean addStudent(Student student) {
        boolean toAdd = true;
        for (Student student1 : students) {
            if (student1.getName().equals(student.getName())) {
                toAdd = false;
                break;
            }
        }
        if (toAdd) {
            students.add(student);
        }
        return toAdd;
    }

    public double calculateClassAverage() {
        if (students.isEmpty()) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        }
        double studensSum = 0.0;
        int studentNum = 0;
        for (Student student : students) {
            if (student.calculateAverage() > 0) {
                studensSum += student.calculateAverage();
                studentNum++;
            } else {
                throw new ArithmeticException("No marks present, average calculation aborted!");
            }
        }
        return Math.round((studensSum / studentNum) * 100) / 100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {
        if (subject == null) {
            throw new NullPointerException("Subject must be provided!");
        }
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
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        }
        Student foundStudent = null;
        for (Student student : students) {
            if (name.equals(student.getName())) {
                foundStudent = student;
                break;
            } else {
                throw new IllegalArgumentException("Student by this name cannot be found! " + name);
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
        if (student == null) {
            throw new NullPointerException("Student must be provided!");
        }
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
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        }
        return students.get(rnd.nextInt(students.size()));
    }

    public String getClassName() {
        return className;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
