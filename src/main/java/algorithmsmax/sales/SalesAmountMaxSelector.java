package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersons){
        Salesperson sp = null;
        for (Salesperson salesperson : salespersons) {
            if (sp == null || salesperson.getAmount() > sp.getAmount()) {
                sp = salesperson;
            }
        }
        return sp;
    }

}
