package visitor;

import seller.Product;

public class VisitorImpl implements Visitor {

    @Override
    public void visit(Product product) {
        product.price = product.price + (product.price * product.inflation/100);
    }
}
