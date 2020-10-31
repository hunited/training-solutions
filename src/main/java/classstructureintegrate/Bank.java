package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String newData = "A számla új adatai: ";

        System.out.println("Mi a számlaszám?");
        String accountNumber = scanner.nextLine();

        System.out.println("Számlatulajdonos neve?");
        String owner = scanner.nextLine();

        System.out.println("Kezdeti befizetés összege?");
        int balance = scanner.nextInt();
        scanner.nextLine();

        BankAccount account = new BankAccount(accountNumber,owner,balance);
        System.out.println("A számla az alábbi adatokkal létrejött:\n"+account.getInfo());

        System.out.println("Mekkora összeget fizet be?");
        int deposit = scanner.nextInt();
        account.deposit(deposit);
        scanner.nextLine();
        System.out.println(newData+account.getInfo());

        System.out.println("Mekkora összeget venne fel?");
        int withdraw = scanner.nextInt();
        account.withdraw(withdraw);
        scanner.nextLine();
        System.out.println(newData+account.getInfo());

        System.out.println("A másik számla száma?");
        String accountNumberTwo = scanner.nextLine();

        System.out.println("A másik számla tulajdonosának a neve?");
        String ownerTwo = scanner.nextLine();

        System.out.println("Kezdeti befizetés összege a másik számlára?");
        int balanceTwo = scanner.nextInt();
        scanner.nextLine();

        BankAccount accountTwo = new BankAccount(accountNumberTwo,ownerTwo,balanceTwo);
        System.out.println("A számla az alábbi adatokkal létrejött:\n"+accountTwo.getInfo());

        System.out.println("Mekkora összeget fizet be?");
        int depositTwo = scanner.nextInt();
        accountTwo.deposit(depositTwo);
        scanner.nextLine();
        System.out.println(newData+accountTwo.getInfo());

        System.out.println("Mekkora összeget venne fel?");
        int withdrawTwo = scanner.nextInt();
        accountTwo.withdraw(withdrawTwo);
        scanner.nextLine();
        System.out.println(newData+accountTwo.getInfo());

        System.out.println("Mekkora összeget utal az elsőről a második számlára?");
        int transfer = scanner.nextInt();
        account.transfer(accountTwo,transfer);
        scanner.nextLine();
        System.out.println("Az első számla új adatai: "+account.getInfo()+"\nA második számla új adatai: "+accountTwo.getInfo());

        System.out.println("Mekkora összeget utal a másodikról az első számlára?");
        int transferTwo = scanner.nextInt();
        accountTwo.transfer(account,transferTwo);
        scanner.nextLine();
        System.out.println("Az első számla új adatai: "+account.getInfo()+"\nA második számla új adatai: "+accountTwo.getInfo());
    }
}
