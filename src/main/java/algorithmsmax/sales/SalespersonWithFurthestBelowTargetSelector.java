package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersons){
        Salesperson sp = null;
        for (Salesperson salesperson : salespersons) {
            if (sp == null || salesperson.getDifferenceFromTarget() < sp.getDifferenceFromTarget()) {
                sp = salesperson;
            }
        }
        return sp;
    }

}
