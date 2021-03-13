package week10.d05S;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator {

    private void findMinMaxSum(int[] arr) {
        Arrays.sort(arr);
        int min = 0;
        int max = 0;
        for (int i = 0; i < 4; i++) {
            min += arr[i];
        }
        System.out.println("Value of first four is: " + min);
        for (int i = arr.length - 4; i < arr.length; i++) {
            max += arr[i];
        }
        System.out.println("Value of last four is: " + max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many number do you want (min. 4)? ");
        int number = Integer.parseInt(scanner.nextLine());
        if (number < 4) {
            throw new IllegalArgumentException("Too little numbers");
        }
        int[] numbers = new int[number];
        System.out.println("Please enter " + number + " numbers!");
        for (int i = 0; i < number; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = Integer.parseInt(scanner.nextLine());
        }
        new Calculator().findMinMaxSum(numbers);
    }

}
