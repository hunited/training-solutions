package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public boolean adProducts(Product product) {
        try {
            products.add(product);
            return true;
        } catch (IllegalStateException ise) {
            return false;
        }

    }

    public int getNumberOfExpired(List<Product> products) {
        int i = 0;
        for (Product p : products) {
            if (p.getExpiryDate().isBefore(LocalDate.now())) {
                System.out.println("Lejárt szavatosságú termék : " + p.getName() + ", lejárati dátum: " + p.getExpiryDate());
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Store s = new Store();
        s.adProducts(new Product("Alma", 2020, 11, 28));
        s.adProducts(new Product("Körte", 2020, 12, 28));
        s.adProducts(new Product("Szőlő", 2020, 11, 28));
        s.adProducts(new Product("Cseresznye", 2021, 11, 28));

        System.out.println("Lejárt termékek száma: " + s.getNumberOfExpired(s.products) + " db.");
    }

}
