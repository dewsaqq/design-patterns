package seller;

import visitor.Visitor;

public class Product {
    public double productionCost;
    public double price;
    public double margin;
    public double inflation;

    public Product(double productionCost, double margin) {
        this.productionCost = productionCost;
        this.margin = margin;
        price = productionCost + margin;
    }

    public Product(double productionCost) {
        this(productionCost, 0.1);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
