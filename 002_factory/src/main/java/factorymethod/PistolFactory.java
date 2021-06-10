package factorymethod;

import weapon.Weapon;
import weapon.pistol.*;

public class PistolFactory extends WeaponFactoryMethod {
    private static PistolFactory instance;

    private PistolFactory() { }

    public static PistolFactory getInstance() {
        if (instance == null) {
            synchronized (PistolFactory.class) {
                instance = new PistolFactory();
            }
        }
        return instance;
    }

    @Override
    public Weapon getWeapon(String type) {
        type = type.toUpperCase();
        switch (type) {
            case "BERETTAM9":
                return new BerettaM9();
            case "COLTM1911":
                return new ColtM1911();
            case "GLOCK19":
                return new Glock19();
            case "RUGERP95":
                return new RugerP95();
            case "WALTHERP22":
                return new WaltherP22();
            default:
                return null;
        }
    }
}
