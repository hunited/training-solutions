package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Mark> marks = new ArrayList<>();

    private String name;

    public Student(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.name = name;
    }

    public double calculateAverage() {
        if (marks == null) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        double marksSum = 0.0;
        for (Mark mark : marks) {
            marksSum += mark.getMarkType().getValue();
        }
        return Math.round((marksSum / marks.size()) * 100) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        if (marks == null) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }
        double marksSum = 0.0;
        int markNum = 0;
        try {
            for (Mark mark : marks) {
                if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                    marksSum += mark.getMarkType().getValue();
                    markNum++;
                }
            }
        } catch (ArithmeticException ae) {
            throw new ArithmeticException("No marks present, average calculation aborted!");
        }

        return Math.round((marksSum / markNum) * 100) / 100.0;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        marks.add(mark);
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    public String toString() {
        String messages = getName();

        for (int i = 0; i < marks.size(); i++) {
            messages += " marks: " + marks.get(i).getSubject().getSubjectName()
                    + ": " + marks.get(i).getMarkType().getDescription()
                    + "(" + marks.get(i).getMarkType().getValue() + ")";
        }
        return messages;
    }

}