package week14.d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private final Contract contract;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        contract = new Contract(client, monthlyPrices);
    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(contract.getMonthlyPrices()));
    }

    public Contract getContract() {
        return contract;
    }

}
