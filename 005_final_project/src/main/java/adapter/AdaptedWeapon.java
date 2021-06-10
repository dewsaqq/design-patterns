package adapter;

import weapon.Weapon;

public class AdaptedWeapon implements WeaponAdapter {
    private Weapon weapon;

    public AdaptedWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String getFullName() {
        return weapon.getName() + " " + weapon.getCartridge();
    }

    @Override
    public String getPriceTag() {
        return Math.round(weapon.getCost()) + " - " + getFullName();
    }
}
