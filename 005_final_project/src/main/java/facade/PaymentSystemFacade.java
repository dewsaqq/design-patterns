package facade;

import model.Customer;

public class PaymentSystemFacade {
    private BankSystem bankSystem;
    private LegalSystem legalSystem;
    private HealthSystem healthSystem;

    public PaymentSystemFacade() {
        bankSystem = new BankSystem();
        legalSystem = new LegalSystem();
        healthSystem = new HealthSystem();
    }

    public boolean makePayment(Customer customer, double weaponCost) {
        if (!bankSystem.validatePin(customer.getCreditCard())) {
            return false;
        } else if (!bankSystem.hasSufficientSavings(customer.getCreditCard(), weaponCost)) {
            return false;
        } else if (!legalSystem.validateFirearmsLicense(customer)) {
            return false;
        } else if (!healthSystem.validateMentalHealthCertificate(customer)) {
            return false;
        }

        System.out.println("Payment succeeded for customer " + customer.getName());
        return true;
    }
}
