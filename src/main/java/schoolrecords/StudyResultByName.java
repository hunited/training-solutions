package schoolrecords;

public class StudyResultByName {

    private String studentName;

    private double studyAverage;

    public StudyResultByName(double studyAverage, String studentName) {
        if (isEmpty(studentName)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.studentName = studentName;
        this.studyAverage = studyAverage;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return studyAverage;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
