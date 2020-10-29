package classstructureconstructors;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store("Gyufa");
        store.setStock(17);
        store.store(50);
        System.out.println(store.getProduct()+" készlet: "+store.getStock());
        store.dispatch(15);
        System.out.println(store.getProduct()+" maradék: "+store.getStock());

        Store storeTwo = new Store("Hurkapálca");
        storeTwo.setStock(42);
        storeTwo.store(100);
        System.out.println(storeTwo.getProduct()+" készlet: "+storeTwo.getStock());
        storeTwo.dispatch(35);
        System.out.println(storeTwo.getProduct()+" maradék: "+storeTwo.getStock());
    }
}
