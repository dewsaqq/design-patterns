package visitor;

import weapon.Weapon;

public class InflationVisitor implements Visitor {
    private double inflationLevel = 0.02;

    @Override
    public void visit(Weapon weapon) {
        double currentCost = weapon.getCost();
        weapon.setCost(currentCost + (currentCost * inflationLevel));
    }
}
