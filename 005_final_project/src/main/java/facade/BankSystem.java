package facade;

import model.CreditCard;

public class BankSystem {
    boolean validatePin(CreditCard creditCard) {
        System.out.println("Validating PIN " + creditCard.getPin());
        return (creditCard.getPin() != 4321);
    }

    boolean hasSufficientSavings(CreditCard creditCard, double weaponCost) {
        System.out.println("Validating credit card savings: " + creditCard.getSavings());
        return !(creditCard.getSavings() < weaponCost);
    }
}
