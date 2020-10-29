package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        System.out.println("Termék neve?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Termék ára?");
        int price = scanner.nextInt();

        Product product = new Product(name, price);
        System.out.println("A(z) "+product.getName()+" ára "+product.getPrice()+" Ft.");

        System.out.println("Mennyivel legyen drágább?");
        product.increasePrice(scanner.nextInt());
        System.out.println("A(z) "+product.getName()+" megnövelt ára "+product.getPrice()+" Ft.");

        System.out.println("Mennyivel legyen olcsóbb?");
        product.decreasePrice(scanner.nextInt());
        System.out.println("A(z) "+product.getName()+" csökkentett ára "+product.getPrice()+" Ft.");
    }
}
