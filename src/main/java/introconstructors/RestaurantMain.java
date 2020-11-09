package introconstructors;

public class RestaurantMain {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant("Testek étterme", 8);

        System.out.println(
                "Köszöntjük a(z) " + restaurant.getName() + " éttermében!"
                + "\nAz ülőhelyek száma: " + restaurant.getCapacity()
                + "\nÉtlapunk: " + restaurant.getMenu()
        );

    }

}
