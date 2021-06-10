import adapter.AdaptedWeapon;
import org.junit.Test;
import weapon.Weapon;
import weapon.pistol.ColtM1911;

import static org.assertj.core.api.Assertions.*;

public class AdapterTest {
    Weapon weapon = new ColtM1911();
    AdaptedWeapon adaptedWeapon = new AdaptedWeapon(weapon);

    @Test
    public void isFullNameCreatedCorrectlyTest() {
        assertThat(weapon.getName() + " " + weapon.getCartridge()).isEqualTo(adaptedWeapon.getFullName());
    }

    @Test
    public void isPriceTagCreatedCorrectlyTest() {
        assertThat(Math.round(weapon.getCost()) + " - " + weapon.getName() + " " + weapon.getCartridge()).isEqualTo(adaptedWeapon.getPriceTag());
    }
}
