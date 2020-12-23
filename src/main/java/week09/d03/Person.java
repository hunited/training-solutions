package week09.d03;

import java.util.Random;

public class Person {

    private final String name;
    private final int age;
    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Random random = new Random(1);
        int rnd = random.nextInt(Present.values().length - 1);
        if (age > 14) {
            present = Present.values()[rnd + 1];
        } else {
            present = Present.values()[rnd];
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    @Override
    public String toString() {
        return name + "(" + age + ") ajándéka: " + present;
    }
}
