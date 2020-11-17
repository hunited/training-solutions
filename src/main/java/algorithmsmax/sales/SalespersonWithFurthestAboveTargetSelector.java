package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersons){
        Salesperson sp = null;
        for (Salesperson salesperson : salespersons) {
            if (sp == null || salesperson.getDifferenceFromTarget() > sp.getDifferenceFromTarget()) {
                sp = salesperson;
            }
        }
        return sp;
    }

}
