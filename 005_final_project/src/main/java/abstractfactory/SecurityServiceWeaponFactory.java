package abstractfactory;

import weapon.pistol.Glock19;
import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.revolver.RugerLCR;
import weapon.shotgun.SPAS12;
import weapon.shotgun.Shotgun;

public class SecurityServiceWeaponFactory implements WeaponAbstractFactory {
    private static SecurityServiceWeaponFactory instance;

    private SecurityServiceWeaponFactory() { }

    public static SecurityServiceWeaponFactory getInstance() {
        if (instance == null) {
            synchronized (SecurityServiceWeaponFactory.class) {
                instance = new SecurityServiceWeaponFactory();
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
        return new RugerLCR();
    }

    @Override
    public Shotgun assembleShotgun() {
        return new SPAS12();
    }
}
