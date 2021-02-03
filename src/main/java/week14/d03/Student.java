package week14.d03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student {

    private final Map<String, List<Integer>> subjects = new HashMap<>();
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public void addMark(String subject, int mark) {
        if (!subjects.containsKey(subject)) {
            subjects.put(subject, new ArrayList<>());
        }
        subjects.get(subject).add(mark);
    }

    public Map<String, List<Integer>> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }

}
