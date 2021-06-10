package observer;

import adapter.AdaptedWeapon;
import visitor.InflationVisitor;
import visitor.Visitor;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Seller implements BuyerObserver {
    private final List<SellerObserver> observers = new ArrayList<>();
    private List<Weapon> weaponCatalog;

    public void addObserver(SellerObserver observer) {
        observers.add(observer);
    }

    public void addWeaponToCatalog(Weapon weapon) {
        weaponCatalog.add(weapon);
    }

    public void notifyAboutCatalog() {
        updateWeaponPrices();
        for (SellerObserver observer : observers) {
            observer.updateWeapons(weaponCatalog);
        }
    }

    private void updateWeaponPrices() {
        System.out.println("Weapon prices increased! New price tags below:");
        System.out.println("==============================================");
        Visitor visitor = new InflationVisitor();
        for (Weapon weapon : weaponCatalog) {
            weapon.accept(visitor);
            AdaptedWeapon adaptedWeapon = new AdaptedWeapon(weapon);
            System.out.println(adaptedWeapon.getPriceTag());
        }
    }

    @Override
    public void updateBoughtWeapon(Weapon weapon) {
        weaponCatalog.remove(weapon);
    }
}
