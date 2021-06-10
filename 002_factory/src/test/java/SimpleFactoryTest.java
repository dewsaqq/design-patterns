import org.junit.Test;
import simplefactory.WeaponSimpleFactory;
import weapon.pistol.Pistol;
import weapon.revolver.Revolver;
import weapon.shotgun.Shotgun;

import static org.assertj.core.api.Assertions.*;

public class SimpleFactoryTest {
    WeaponSimpleFactory factory = WeaponSimpleFactory.getInstance();

    @Test
    public void isFactorySingletonTest() {
        boolean areSameInstances = true;

        for(int i = 0; i < 50; i++) {
            WeaponSimpleFactory factory1 = WeaponSimpleFactory.getInstance();
            WeaponSimpleFactory factory2 = WeaponSimpleFactory.getInstance();
            if(factory1.hashCode() != factory2.hashCode()) areSameInstances = false;
        }

        assertThat(areSameInstances).isEqualTo(true);
    }

    @Test
    public void isPistolAssembledProperlyTest() {
        Pistol pistol = factory.assemblePistol("Glock19");

        assertThat(pistol.assemble()).isEqualTo("Glock 19 assembled");
    }

    @Test
    public void isRevolverAssembledProperlyTest() {
        Revolver revolver = factory.assembleRevolver("ColtPython");

        assertThat(revolver.assemble()).isEqualTo("Colt Python assembled");
    }

    @Test
    public void isShotgunAssembledProperlyTest() {
        Shotgun shotgun = factory.assembleShotgun("SPAS12");

        assertThat(shotgun.assemble()).isEqualTo("SPAS-12 assembled");
    }
}
