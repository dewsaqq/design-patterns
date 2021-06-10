import factorymethod.*;
import org.junit.Test;
import weapon.Weapon;

import static org.assertj.core.api.Assertions.*;

public class FactoryMethodTest {
    WeaponFactoryMethod pistolFactory = PistolFactory.getInstance();
    WeaponFactoryMethod revolverFactory = RevolverFactory.getInstance();
    WeaponFactoryMethod shotgunFactory = ShotgunFactory.getInstance();

    @Test
    public void areFactoriesSingletonsTest() {
        boolean areSameInstances = true;

        for(int i = 0; i < 50; i++) {
            WeaponFactoryMethod pistolFactory1 = PistolFactory.getInstance();
            WeaponFactoryMethod revolverFactory1 = RevolverFactory.getInstance();
            WeaponFactoryMethod shotgunFactory1 = ShotgunFactory.getInstance();
            WeaponFactoryMethod pistolFactory2 = PistolFactory.getInstance();
            WeaponFactoryMethod revolverFactory2 = RevolverFactory.getInstance();
            WeaponFactoryMethod shotgunFactory2 = ShotgunFactory.getInstance();
            if(pistolFactory1.hashCode() != pistolFactory2.hashCode() ||
                    revolverFactory1.hashCode() != revolverFactory2.hashCode() ||
                    shotgunFactory1.hashCode() != shotgunFactory2.hashCode()) areSameInstances = false;
        }

        assertThat(areSameInstances).isEqualTo(true);
    }

    @Test
    public void isPistolAssembledProperlyTest() {
        Weapon pistol = pistolFactory.getWeapon("BerettaM9");

        assertThat(pistol.assemble()).isEqualTo("Beretta M9 assembled");
    }

    @Test
    public void isRevolverAssembledProperlyTest() {
        Weapon revolver = revolverFactory.getWeapon("ColtAnaconda");

        assertThat(revolver.assemble()).isEqualTo("Colt Anaconda assembled");
    }

    @Test
    public void isShotgunAssembledProperlyTest() {
        Weapon shotgun = shotgunFactory.getWeapon("USAS12");

        assertThat(shotgun.assemble()).isEqualTo("USAS-12 assembled");
    }
}
