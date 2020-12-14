package week05.d04;

import java.time.LocalDate;

public class Product {

    private String name;

    private LocalDate expiryDate;

    public Product(String name, int year, int month, int day) {
        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException("A név nem lehet null vagy üres.");
        } else if (year < 2010 || year > 2030 || month < 1 || month > 12 || day < 1 || day > 31) {
            throw new IllegalArgumentException("A dátum nem lehet 2010 előtti vagy 2030 utáni.");
        }
        this.name = name;
        this.expiryDate = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

}
