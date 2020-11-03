package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMem() {
        return mem;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phone phoneOne = new Phone("Samsung A1",2);
        Phone phoneTwo = new Phone("Samsung A2",4);
        System.out.println("Ez egy " + phoneOne.type + " telefon " + phoneOne.mem + "GB memóriával.");
        System.out.println("Ez egy " + phoneTwo.type + " telefon " + phoneTwo.mem + "GB memóriával.");
    }
}
