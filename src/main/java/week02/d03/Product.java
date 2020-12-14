package week02.d03;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    /* Én megoldásom
    public boolean areTheyEqual(Product p) {
        return (name.equals(p.getName()) &&
               (code.length() == p.code.length() || code.length() == p.code.length()+1 || code.length() == p.code.length()-1)
        );
    }
    */

    // Tanár megoldása
    public boolean areTheyEqual(Product p) {
        boolean nameEqual = name.equals(p.getName());
        boolean codeDifference = Math.abs(code.length()-p.getCode().length()) <= 1;
        return nameEqual && codeDifference;
    }

    public static void main(String[] args) {
        Product product1 = new Product("alma", "a01");
        Product product2 = new Product("alma", "a0");
        Product product3 = new Product("körte", "a03");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product2.areTheyEqual(product3));
    }
}
