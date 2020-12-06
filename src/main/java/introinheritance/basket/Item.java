package introinheritance.basket;

public class Item {

    private String barcode;
    private double nettoPrice;
    private int vatPercent;

    public Item(String barcode, double nettoPrice, int vatPercent) {
        this.barcode = barcode;
        this.nettoPrice = nettoPrice;
        this.vatPercent = vatPercent;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getNettoPrice() {
        return nettoPrice;
    }

    public double getTaxAmount() {
        return nettoPrice * (vatPercent / 100.0);
    }

    @Override
    public String toString() {
        return "Item{" +
                "barcode='" + barcode + '\'' +
                ", nettoPrice=" + nettoPrice +
                ", vatPercent=" + vatPercent +
                '}';
    }

}
