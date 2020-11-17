package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {

    private String name;

    private List<Subject> taughtSubject = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Tutor(String name, List<Subject> taughtSubject) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
        this.taughtSubject = taughtSubject;
    }

    public boolean tutorTeachingSubject(Subject subject) {
        boolean found = false;
        for (Subject sub : taughtSubject) {
            if (sub.getSubjectName().equals(subject.getSubjectName())) {
                found = true;
                break;
            }
        }
        return found;
    }

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }

}
