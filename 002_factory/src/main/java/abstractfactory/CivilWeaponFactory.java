package abstractfactory;

import weapon.pistol.ColtM1911;
import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.revolver.TaurusJudge;
import weapon.shotgun.Mossberg590;
import weapon.shotgun.Shotgun;

public class CivilWeaponFactory implements WeaponAbstractFactory {
    private static CivilWeaponFactory instance;

    private CivilWeaponFactory() { }

    public static CivilWeaponFactory getInstance() {
        if (instance == null) {
            synchronized (CivilWeaponFactory.class) {
                instance = new CivilWeaponFactory();
            }
        }
        return instance;
    }

    @Override
    public Pistol assemblePistol() {
        return new ColtM1911();
    }

    @Override
    public Revolver assembleRevolver() {
        return new TaurusJudge();
    }

    @Override
    public Shotgun assembleShotgun() {
        return new Mossberg590();
    }
}
