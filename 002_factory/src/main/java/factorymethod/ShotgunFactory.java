package factorymethod;

import weapon.Weapon;
import weapon.shotgun.*;

public class ShotgunFactory extends WeaponFactoryMethod {
    private static ShotgunFactory instance;

    private ShotgunFactory() { }

    public static ShotgunFactory getInstance() {
        if (instance == null) {
            synchronized (ShotgunFactory.class) {
                instance = new ShotgunFactory();
            }
        }
        return instance;
    }

    @Override
    public Weapon getWeapon(String type) {
        type = type.toUpperCase();
        switch (type) {
            case "ARMSELSTRIKER":
                return new ArmselStriker();
            case "BENELLIM4":
                return new BenelliM4();
            case "MOSSBERG590":
                return new Mossberg590();
            case "SPAS12":
                return new SPAS12();
            case "USAS12":
                return new USAS12();
            default:
                return null;
        }    }
}
