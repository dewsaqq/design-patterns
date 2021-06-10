package model;

public class Customer {
    private final String name;
    private final boolean hasFirearmsLicense;
    private final boolean hasMentalHealthCertificate;
    private final CreditCard creditCard;

    public Customer(String name, boolean hasFirearmsLicense, boolean hasMentalHealthCertificate, CreditCard creditCard) {
        this.name = name;
        this.hasFirearmsLicense = hasFirearmsLicense;
        this.hasMentalHealthCertificate = hasMentalHealthCertificate;
        this.creditCard = creditCard;
    }

    public String getName() {
        return name;
    }

    public boolean hasFirearmsLicense() {
        return hasFirearmsLicense;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public boolean hasMentalHealthCertificate() {
        return hasMentalHealthCertificate;
    }
}
