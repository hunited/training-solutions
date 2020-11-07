package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 0.27;

    public double tax(double price) {
        return price * VAT;
    }

    public double priceWithTax(double price) {
        return price * (1+VAT);
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();

        System.out.println(taxCalculator.tax(1000));
        System.out.println(taxCalculator.priceWithTax(1000));
    }

}
