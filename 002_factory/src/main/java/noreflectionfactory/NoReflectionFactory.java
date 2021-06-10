package noreflectionfactory;

import weapon.Weapon;

import java.util.HashMap;
import java.util.function.Supplier;

public class NoReflectionFactory {
    private static NoReflectionFactory instance;
    private final HashMap<String, Supplier<? extends Weapon>> registeredSuppliers = new HashMap<>();

    private NoReflectionFactory() { }

    public static NoReflectionFactory getInstance() {
        if (instance == null) {
            synchronized (NoReflectionFactory.class) {
                instance = new NoReflectionFactory();
            }
        }
        return instance;
    }

    public void registerType(String type, Supplier<? extends Weapon> supplier) {
        registeredSuppliers.put(type, supplier);
    }

    public Weapon getProduct(String type) {
        Supplier<? extends Weapon> supplier = registeredSuppliers.get(type);
        return supplier != null ? supplier.get() : null;
    }
}
