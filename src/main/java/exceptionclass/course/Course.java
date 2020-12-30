package exceptionclass.course;

public class Course {

    private String name;
    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException("Name must not be empty");
        }
        this.name = name;
        if (begin == null) {
            throw new IllegalArgumentException("Begin must not be empty");
        }
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return begin + ": " + name;
    }
}
