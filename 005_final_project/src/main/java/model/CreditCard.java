package model;

public class CreditCard {
    private final int pin;
    private final double savings;

    public CreditCard(int pin, double savings) {
        this.pin = pin;
        this.savings = savings;
    }

    public int getPin() {
        return pin;
    }

    public double getSavings() {
        return savings;
    }
}
