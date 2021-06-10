import facade.PaymentSystemFacade;
import model.CreditCard;
import model.Customer;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FacadeTest {
    PaymentSystemFacade psf = new PaymentSystemFacade();

    CreditCard validCreditCard = new CreditCard(1234, 389.90);
    CreditCard invalidCreditCard1 = new CreditCard(4321, 780.23);
    CreditCard invalidCreditCard2 = new CreditCard(5555, 11.23);

    @Test
    public void isInvalidPinRejectedProperlyTest() {
        Customer customer = new Customer("Frank", true, true, invalidCreditCard1);

        assertThat(psf.makePayment(customer, 10.0)).isEqualTo(false);
    }

    @Test
    public void isInvalidSavingsAmountRejectedProperlyTest() {
        Customer customer = new Customer("Frank", true, true, invalidCreditCard2);

        assertThat(psf.makePayment(customer, 13.5)).isEqualTo(false);
    }

    @Test
    public void isInvalidFirearmsLicenseRejectedProperlyTest() {
        Customer customer = new Customer("Frank", false, true, validCreditCard);

        assertThat(psf.makePayment(customer, 100.0)).isEqualTo(false);
    }

    @Test
    public void isInvalidMentalHealthCertificateRejectedProperlyTest() {
        Customer customer = new Customer("Frank", true, false, validCreditCard);

        assertThat(psf.makePayment(customer, 100.0)).isEqualTo(false);
    }

    @Test
    public void isValidCustomerAcceptedProperlyTest() {
        Customer customer = new Customer("Frank", true, true, validCreditCard);

        assertThat(psf.makePayment(customer, 100.0)).isEqualTo(true);
    }
}
