package observer;

import weapon.Weapon;

public interface BuyerObserver {
    void updateBoughtWeapon(Weapon weapon);
}
