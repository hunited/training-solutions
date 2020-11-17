package schoolrecords;

public class Subject {

    private String subjectName;

    public Subject(String subjectName) {
        if (isEmpty(subjectName)) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }
}
