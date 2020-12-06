package introinheritance.basket;

public class ShoppingBasket {

    private Basket basket = new Basket();

    public void addItem(Item item) {
        basket.addItem(item);
    }

    public void removeItem(String barcode) {
        basket.removeItem(barcode);
    }

    public double sumNettoPrice() {
        double sum = 0.0;
        for (Item item : basket.getItems()) {
            sum += item.getNettoPrice();
        }
        return sum;
    }

    public double sumTaxValue() {
        double sum = 0.0;
        for (Item item : basket.getItems()) {
            sum += item.getTaxAmount();
        }
        return sum;
    }

    public double sumBruttoPrice() {
        return sumNettoPrice() + sumTaxValue();
    }

    public void checkout() {
        basket.clearBasket();
    }

    public void removeMostExpensiveItem() {
        double temp = basket.getItems().get(0).getNettoPrice();
        int index = 0;
        for (int i = 1; i < basket.getItems().size(); i++) {
            if (basket.getItems().get(i).getNettoPrice() > temp) {
                temp = basket.getItems().get(i).getNettoPrice();
                index = i;
            }
        }
        basket.removeItem(basket.getItems().get(index).getBarcode());
    }

}
