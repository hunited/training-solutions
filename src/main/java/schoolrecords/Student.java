package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private final List<Mark> marks = new ArrayList<>();

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public double calculateAverage() {
        double marksSum = 0.0;
        for (Mark mark : marks) {
            marksSum += mark.getMarkType().getValue();
        }
        return Math.round((marksSum / marks.size()) * 100) / 100.0;
    }

    public double calculateSubjectAverage(Subject subject) {
        double marksSum = 0.0;
        int markNum = 0;
        for (Mark mark : marks) {
            if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                marksSum += mark.getMarkType().getValue();
                markNum++;
            }
        }
        return Math.round((marksSum / markNum) * 100) / 100.0;
    }

    public String getName() {
        return name;
    }

    public void grading(Mark mark) {
        marks.add(mark);
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

    @Override
    public String toString() {
        String messages = getName();

        for (int i = 0; i < marks.size(); i++) {
            messages += "marks: " + marks.get(i).getSubject().getSubjectName()
                    + ": " + marks.get(i).getMarkType().getDescription()
                    + "(" + marks.get(i).getMarkType().getValue() + ")";
        }
        return messages;
    }

}