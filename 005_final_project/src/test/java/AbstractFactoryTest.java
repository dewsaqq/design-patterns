import abstractfactory.*;
import org.junit.Test;
import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.shotgun.Shotgun;

import static org.assertj.core.api.Assertions.*;

public class AbstractFactoryTest {
    WeaponAbstractFactory civilFactory = CivilWeaponFactory.getInstance();
    WeaponAbstractFactory militaryFactory = MilitaryWeaponFactory.getInstance();
    WeaponAbstractFactory policeFactory = PoliceWeaponFactory.getInstance();
    WeaponAbstractFactory securityFactory = SecurityServiceWeaponFactory.getInstance();

    @Test
    public void areFactoriesSingletonsTest() {
        boolean areSameInstances = true;

        for(int i = 0; i < 50; i++) {
            WeaponAbstractFactory civilFactory1 = CivilWeaponFactory.getInstance();
            WeaponAbstractFactory militaryFactory1 = MilitaryWeaponFactory.getInstance();
            WeaponAbstractFactory policeFactory1 = PoliceWeaponFactory.getInstance();
            WeaponAbstractFactory securityFactory1 = SecurityServiceWeaponFactory.getInstance();
            WeaponAbstractFactory civilFactory2 = CivilWeaponFactory.getInstance();
            WeaponAbstractFactory militaryFactory2 = MilitaryWeaponFactory.getInstance();
            WeaponAbstractFactory policeFactory2 = PoliceWeaponFactory.getInstance();
            WeaponAbstractFactory securityFactory2 = SecurityServiceWeaponFactory.getInstance();
            if(civilFactory1.hashCode() != civilFactory2.hashCode() ||
                    militaryFactory1.hashCode() != militaryFactory2.hashCode() ||
                    policeFactory1.hashCode() != policeFactory2.hashCode() ||
                    securityFactory1.hashCode() != securityFactory2.hashCode()) areSameInstances = false;
        }

        assertThat(areSameInstances).isEqualTo(true);
    }

    @Test
    public void areCivilWeaponsAssembledProperlyTest() {
        Pistol pistol = civilFactory.assemblePistol();
        Revolver revolver = civilFactory.assembleRevolver();
        Shotgun shotgun = civilFactory.assembleShotgun();

        assertThat(pistol.assemble()).isEqualTo("Colt M1911 assembled");
        assertThat(revolver.assemble()).isEqualTo("Taurus Judge assembled");
        assertThat(shotgun.assemble()).isEqualTo("Mossberg 590 assembled");
    }

    @Test
    public void areMilitaryWeaponsAssembledProperlyTest() {
        Pistol pistol = militaryFactory.assemblePistol();
        Revolver revolver = militaryFactory.assembleRevolver();
        Shotgun shotgun = militaryFactory.assembleShotgun();

        assertThat(pistol.assemble()).isEqualTo("Beretta M9 assembled");
        assertThat(revolver.assemble()).isEqualTo("Colt Python assembled");
        assertThat(shotgun.assemble()).isEqualTo("Armsel Striker assembled");
    }

    @Test
    public void arePoliceWeaponsAssembledProperlyTest() {
        Pistol pistol = policeFactory.assemblePistol();
        Revolver revolver = policeFactory.assembleRevolver();
        Shotgun shotgun = policeFactory.assembleShotgun();

        assertThat(pistol.assemble()).isEqualTo("Glock 19 assembled");
        assertThat(revolver.assemble()).isEqualTo("Smith & Wesson Model 15 assembled");
        assertThat(shotgun.assemble()).isEqualTo("Benelli M4 assembled");
    }

    @Test
    public void areSecurityWeaponsAssembledProperlyTest() {
        Pistol pistol = securityFactory.assemblePistol();
        Revolver revolver = securityFactory.assembleRevolver();
        Shotgun shotgun = securityFactory.assembleShotgun();

        assertThat(pistol.assemble()).isEqualTo("Glock 19 assembled");
        assertThat(revolver.assemble()).isEqualTo("Ruger LCR assembled");
        assertThat(shotgun.assemble()).isEqualTo("SPAS-12 assembled");
    }
}
