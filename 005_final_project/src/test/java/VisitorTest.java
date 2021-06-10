import org.junit.Before;
import org.junit.Test;
import visitor.InflationVisitor;
import visitor.Visitor;
import weapon.Weapon;
import weapon.pistol.ColtM1911;
import weapon.revolver.ColtAnaconda;
import weapon.shotgun.SPAS12;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class VisitorTest {
    Visitor visitor = new InflationVisitor();
    List<Weapon> weaponList;

    @Before
    public void initialize() {
        weaponList = new ArrayList<>();
        weaponList.add(new ColtM1911());
        weaponList.add(new ColtAnaconda());
        weaponList.add(new SPAS12());
    }

    @Test
    public void pricesAreIncreasedCorrectlyTest() {
        double sumBeforeIncreaseInValue = 0.0;
        double sumAfterIncreaseInValue = 0.0;
        
        for (Weapon weapon : weaponList) {
            sumBeforeIncreaseInValue += weapon.getCost();
            weapon.accept(visitor);
        }
        
        for (Weapon weapon : weaponList) {
            sumAfterIncreaseInValue += weapon.getCost();
        }

        assertThat(Math.round(sumAfterIncreaseInValue)).isEqualTo(Math.round(sumBeforeIncreaseInValue + sumBeforeIncreaseInValue * 0.02));
    }
}
