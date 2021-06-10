package abstractfactory;

import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.shotgun.Shotgun;

public interface WeaponAbstractFactory {
    Pistol assemblePistol();
    Revolver assembleRevolver();
    Shotgun assembleShotgun();
}
