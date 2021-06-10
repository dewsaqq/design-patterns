package facade;

import model.Customer;

public class LegalSystem {
    boolean validateFirearmsLicense(Customer customer) {
        System.out.println("Validating firearms license...");
        return customer.hasFirearmsLicense();
    }
}
