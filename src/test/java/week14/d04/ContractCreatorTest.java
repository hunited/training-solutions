package week14.d04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContractCreatorTest {

    ContractCreator cc = new ContractCreator("Sanyi",
            List.of(100, 120, 130, 140, 150, 160, 170, 180, 190, 200, 210, 220)
    );
    Contract contract = cc.create("Gizi");
    Contract contract2 = cc.create("Juli");

    @Test
    void createTest() {
        assertEquals("Mari", cc.create("Mari").getClient());
    }

    @Test
    void modifyDecemberTest() {
        contract.getMonthlyPrices().set(11, 300);
        assertEquals(300, contract.getMonthlyPrices().get(11));

        assertEquals("Juli", contract2.getClient());
        assertEquals(220, contract2.getMonthlyPrices().get(11));
    }

    @Test
    void getContract() {
        assertEquals("Sanyi", cc.getContract().getClient());
    }

}
