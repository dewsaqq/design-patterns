import bank.CentralBank;
import buyer.Buyer;
import seller.Product;
import seller.Seller;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Product product1 = new Product(11.0);
        Product product2 = new Product(108.0, 20.0);
        Product product3 = new Product(700.0);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        CentralBank bank = new CentralBank(3.0);
        Buyer buyer = new Buyer(600.0);
        Buyer buyer2 = new Buyer(6000.0);
        Seller seller = new Seller(products);
        bank.addObserver(buyer);
        bank.addObserver(buyer2);
        bank.addObserver(seller);
        seller.addObserver(buyer);
        seller.addObserver(buyer2);
        seller.addObserver(bank);
        buyer.addObserver(bank);
        buyer2.addObserver(bank);

        for (int i = 0; i < 10; i++) {
            System.out.println("==========" + (i+1) + " unit of time==========");
            bank.notifyAboutInflation();
            seller.notifyAboutOffers();
            buyer.notifyAboutSales();
            System.out.println("Bank taxes: " + bank.taxes);
            System.out.println("Bank inflation: " + bank.inflation);
            System.out.println("Prod1 price: " + product1.price);
            System.out.println("Prod2 price: " + product2.price);
            System.out.println("Prod3 price: " + product3.price);
            bank.calculateTaxes();
        }
    }
}
