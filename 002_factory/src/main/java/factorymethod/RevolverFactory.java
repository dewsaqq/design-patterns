package factorymethod;

import weapon.Weapon;
import weapon.revolver.*;

public class RevolverFactory extends WeaponFactoryMethod {
    private static RevolverFactory instance;

    private RevolverFactory() { }

    public static RevolverFactory getInstance() {
        if (instance == null) {
            synchronized (RevolverFactory.class) {
                instance = new RevolverFactory();
            }
        }
        return instance;
    }

    @Override
    public Weapon getWeapon(String type) {
        type = type.toUpperCase();
        switch (type) {
            case "COLTANACONDA":
                return new ColtAnaconda();
            case "COLTPYTHON":
                return new ColtPython();
            case "RUGERLCR":
                return new RugerLCR();
            case "SWMODEL15":
                return new SWModel15();
            case "TAURUSJUDGE":
                return new TaurusJudge();
            default:
                return null;
        }    }
}
