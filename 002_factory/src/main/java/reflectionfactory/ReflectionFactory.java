package reflectionfactory;

import weapon.Weapon;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ReflectionFactory {
    private static ReflectionFactory instance;
    private final HashMap<String, Class<?>> registeredWeapons = new HashMap<>();

    private ReflectionFactory() { }

    public static ReflectionFactory getInstance() {
        if (instance == null) {
            synchronized (ReflectionFactory.class) {
                instance = new ReflectionFactory();
            }
        }
        return instance;
    }

    public void registerWeapon(String type, Class<?> _class) {
        registeredWeapons.put(type, _class);
    }

    public Weapon createWeapon(String type) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> weaponClass = registeredWeapons.get(type);
        Constructor<?> weaponConstructor = weaponClass.getDeclaredConstructor();
        return (Weapon) weaponConstructor.newInstance(new Object[] { });
    }

    public Weapon assembleWeapon(String type) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Weapon weapon = instance.createWeapon(type);
        return weapon;
    }
}
