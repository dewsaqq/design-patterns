package buyer;

import bank.BankObserver;
import seller.Product;
import seller.SellerObserver;

import java.util.ArrayList;
import java.util.List;

public class Buyer implements BankObserver, SellerObserver {
    private final List<BuyerObserver> observers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private double inflation;
    private double amountOfMoney;
    private double moneySpent = 0.0;

    public Buyer(double startingMoney) {
        amountOfMoney = startingMoney;
    }

    public void addObserver(BuyerObserver observer) {
        observers.add(observer);
    }

    @Override
    public void updateInflation(double inflation) {
        this.inflation = inflation;
    }

    @Override
    public void updateProducts(List<Product> products) {
        this.products = products;
        for (Product product : this.products) {
            if (product.price < 0.8 * amountOfMoney) buyProduct(product);
        }
    }

    public void notifyAboutSales() {
        for (BuyerObserver observer : observers) {
            observer.updateSales(moneySpent);
        }
        moneySpent = 0.0;
    }

    private void buyProduct(Product product) {
        amountOfMoney -= product.price;
        moneySpent += product.price;
    }

}
