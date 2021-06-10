package observer;

import adapter.AdaptedWeapon;
import facade.PaymentSystemFacade;
import model.Customer;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Buyer implements SellerObserver {
    private final List<BuyerObserver> observers = new ArrayList<>();
    private List<Weapon> availableWeapons = new ArrayList<>();
    private Customer customer;
    private Weapon weaponToBuy = null;

    public Buyer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void updateWeapons(List<Weapon> weapons) {
        availableWeapons = weapons;
        if(availableWeapons.size() != 0) buyWeapon(availableWeapons.get(0));
    }

    public void notifyAboutBoughtWeapon() {
        for (BuyerObserver observer : observers) {
            observer.updateBoughtWeapon(weaponToBuy);
        }
        weaponToBuy = null;
    }

    public void buyWeapon(Weapon weapon) {
        PaymentSystemFacade psf = new PaymentSystemFacade();
        if(psf.makePayment(customer, weapon.getCost())) {
            weaponToBuy = weapon;
            AdaptedWeapon adaptedWeapon = new AdaptedWeapon(weaponToBuy);
            System.out.println("Bought weapon named: " + adaptedWeapon.getFullName());
        }
    }
}
