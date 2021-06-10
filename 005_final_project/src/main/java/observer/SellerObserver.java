package observer;

import weapon.Weapon;

import java.util.List;

public interface SellerObserver {
    void updateWeapons(List<Weapon> weapons);
}
