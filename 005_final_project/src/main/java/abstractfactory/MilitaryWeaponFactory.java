package abstractfactory;

import weapon.pistol.BerettaM9;
import weapon.pistol.Pistol;
import weapon.revolver.ColtPython;
import weapon.revolver.Revolver;
import weapon.shotgun.ArmselStriker;
import weapon.shotgun.Shotgun;

public class MilitaryWeaponFactory implements WeaponAbstractFactory {
    private static MilitaryWeaponFactory instance;

    private MilitaryWeaponFactory() { }

    public static MilitaryWeaponFactory getInstance() {
        if (instance == null) {
            synchronized (MilitaryWeaponFactory.class) {
                instance = new MilitaryWeaponFactory();
            }
        }
        return instance;
    }

    @Override
    public Pistol assemblePistol() {
        return new BerettaM9();
    }

    @Override
    public Revolver assembleRevolver() {
        return new ColtPython();
    }

    @Override
    public Shotgun assembleShotgun() {
        return new ArmselStriker();
    }
}
