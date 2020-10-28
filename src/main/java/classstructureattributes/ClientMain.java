package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Kérlek add meg a neved!");
        client.name = scanner.nextLine();
        System.out.println("Melyik évben születtél?");
        client.year = scanner.nextInt();
        client.address = scanner.nextLine();
        System.out.println("Kérlek add meg a címed!");
        client.address = scanner.nextLine();
        System.out.println("Név: "+client.name+", Születési év: "+ client.year+", Cím: "+client.address);
    }
}
