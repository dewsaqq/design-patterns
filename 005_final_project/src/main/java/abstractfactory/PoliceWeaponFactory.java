package abstractfactory;

import weapon.pistol.Glock19;
import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.revolver.SWModel15;
import weapon.shotgun.BenelliM4;
import weapon.shotgun.Shotgun;

public class PoliceWeaponFactory implements WeaponAbstractFactory {
    private static PoliceWeaponFactory instance;

    private PoliceWeaponFactory() { }

    public static PoliceWeaponFactory getInstance() {
        if (instance == null) {
            synchronized (PoliceWeaponFactory.class) {
                instance = new PoliceWeaponFactory();
            }
        }
        return instance;
    }

    @Override
    public Pistol assemblePistol() {
        return new Glock19();
    }

    @Override
    public Revolver assembleRevolver() {
        return new SWModel15();
    }

    @Override
    public Shotgun assembleShotgun() {
        return new BenelliM4();
    }
}
