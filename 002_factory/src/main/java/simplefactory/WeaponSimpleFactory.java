package simplefactory;

import weapon.pistol.*;
import weapon.revolver.*;
import weapon.shotgun.*;

public class WeaponSimpleFactory {
    private static WeaponSimpleFactory instance;

    private WeaponSimpleFactory() { }

    public static WeaponSimpleFactory getInstance() {
        if (instance == null) {
            synchronized (WeaponSimpleFactory.class) {
                instance = new WeaponSimpleFactory();
            }
        }
        return instance;
    }

    public Pistol assemblePistol(String type) {
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

    public Revolver assembleRevolver(String type) {
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
        }
    }

    public Shotgun assembleShotgun(String type) {
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
        }
    }
}
