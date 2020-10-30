package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();

        client.setName("Teszt Elek");
        client.setYear(1980);
        client.setAddress("Gödöllő Fő utca 1");

        System.out.println("Név: "+client.getName()+"\nSzületett: "+client.getYear()+"\nLakcím: "+client.getAddress());

        client.migrate("Gödöllő, Babati utca 17");
        System.out.println("Az új címe: "+client.getAddress());
    }
}
