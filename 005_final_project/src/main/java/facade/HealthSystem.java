package facade;

import model.Customer;

public class HealthSystem {
    boolean validateMentalHealthCertificate(Customer customer) {
        System.out.println("Validating customer mental health certificate...");
        return customer.hasMentalHealthCertificate();
    }
}
