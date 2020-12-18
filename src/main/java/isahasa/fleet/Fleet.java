package isahasa.fleet;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Ship> ships = new ArrayList<>();
    private int waitingPersons;
    private int waitingCargo;

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public void loadShip(int numberOfPersons, int cargoWeight) {
        for (Ship ship : ships) {
            if (ship instanceof CanCarryPassengers) {
                if (numberOfPersons != 0) {
                    numberOfPersons = ((CanCarryPassengers) ship).loadPassenger(numberOfPersons);
                }
            }
            if (ship instanceof CanCarryGoods) {
                if (cargoWeight != 0) {
                    cargoWeight = ((CanCarryGoods) ship).loadCargo(cargoWeight);
                }
            }
        }
        waitingPersons = numberOfPersons;
        waitingCargo = cargoWeight;
    }

    public int getWaitingPersons() {
        return waitingPersons;
    }

    public int getWaitingCargo() {
        return waitingCargo;
    }
}
