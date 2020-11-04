package week02;

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

    public boolean areTheyEqual(Product p) {
        return (name.equals(p.getName()) &&
               (code.length() == p.code.length() || code.length() == p.code.length()+1 || code.length() == p.code.length()-1)
        );
    }

    public static void main(String[] args) {
        Product product1 = new Product("alma", "a01");
        Product product2 = new Product("alma", "a0");
        Product product3 = new Product("körte", "a03");

        System.out.println(product1.areTheyEqual(product2));
        System.out.println(product2.areTheyEqual(product3));
    }
}
