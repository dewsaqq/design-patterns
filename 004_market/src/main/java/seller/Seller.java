package seller;

import bank.BankObserver;
import visitor.Visitor;
import visitor.VisitorImpl;

import java.util.ArrayList;
import java.util.List;

public class Seller implements BankObserver {
    private final List<SellerObserver> observers = new ArrayList<>();
    private List<Product> products;
    private double inflation;

    public Seller(List<Product> products) {
        this.products = products;
    }

    public void addObserver(SellerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void updateInflation(double inflation) {
        this.inflation = inflation;
        Visitor visitor = new VisitorImpl();
        for (Product product : products) {
            product.inflation = inflation;
            product.accept(visitor);
        }
    }

    public void notifyAboutOffers() {
        for (SellerObserver observer : observers) {
            observer.updateProducts(products);
        }
    }

}
