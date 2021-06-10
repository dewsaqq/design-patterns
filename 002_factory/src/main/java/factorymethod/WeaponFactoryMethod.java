package factorymethod;

import weapon.Weapon;

public abstract class WeaponFactoryMethod {
    public abstract Weapon getWeapon(String type);

    public String assembleWeapon(String type) {
        return getWeapon(type).assemble();
    }
}
