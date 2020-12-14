package week02.d02;

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

        Phone phoneOne = new Phone("Samsung A1", 2);
        Phone phoneTwo = new Phone("Samsung A2", 4);
        System.out.println("Ez egy " + phoneOne.type + " telefon " + phoneOne.mem + "GB memóriával.");
        System.out.println("Ez egy " + phoneTwo.type + " telefon " + phoneTwo.mem + "GB memóriával.");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add meg a telefon típusát!");
        String type = scanner.nextLine();
        System.out.println("Add meg a memória méretét!");
        int mem = Integer.parseInt(scanner.nextLine());
        Phone phoneThree = new Phone(type, mem);
        System.out.println("Ez egy " + phoneThree.type + " telefon " + phoneThree.mem + "GB memóriával.");
    }
}
