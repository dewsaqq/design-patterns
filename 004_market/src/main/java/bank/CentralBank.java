package bank;

import buyer.BuyerObserver;
import seller.Product;
import seller.SellerObserver;

import java.util.ArrayList;
import java.util.List;

public class CentralBank implements SellerObserver, BuyerObserver {
    private final List<BankObserver> observers = new ArrayList<>();
    public double sales = 0.0;
    public double inflation;
    public double taxes = 0.0;
    public double oldProductsCost = 0.0;
    public double productsCost = 0.0;

    public CentralBank(double startingInflation) {
        inflation = startingInflation;
    }

    public void addObserver(BankObserver observer) {
        observers.add(observer);
    }

    public void notifyAboutInflation() {
        for (BankObserver observer : observers) {
            observer.updateInflation(inflation);
        }
    }

    public void calculateTaxes() {
        double oldTaxes = taxes;
        oldProductsCost = productsCost;
        taxes = sales * inflation;
        sales = 0.0;
        if (oldTaxes < taxes) {
            inflation--;
        } else inflation++;
        if (inflation <= 0.0) inflation = 0.1;
    }

    @Override
    public void updateSales(double moneySpent) {
        sales += moneySpent;
    }

    @Override
    public void updateProducts(List<Product> products) {
        for (Product product : products) {
            productsCost += product.price;
        }
    }
}
