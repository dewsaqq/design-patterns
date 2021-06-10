import abstractfactory.CivilWeaponFactory;
import abstractfactory.WeaponAbstractFactory;
import noreflectionfactory.NoReflectionFactory;
import reflectionfactory.ReflectionFactory;
import factorymethod.PistolFactory;
import factorymethod.WeaponFactoryMethod;
import org.junit.Test;
import simplefactory.WeaponSimpleFactory;
import weapon.Weapon;
import weapon.pistol.Glock19;
import weapon.pistol.Pistol;

import java.lang.reflect.InvocationTargetException;

public class FactoriesTimeTest {
    @Test
    public void factoriesTimeTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        long startTime, endTime, timeElapsed;
        int numberOfIterations = 10000000;

        // Simple Factory
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            WeaponSimpleFactory simpleFactory = WeaponSimpleFactory.getInstance();
            Weapon pistol = simpleFactory.assemblePistol("GLOCK19");
        }
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("SimpleFactory" + timeElapsed + " ms");

        // Factory Method
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            WeaponFactoryMethod factory = PistolFactory.getInstance();
            Weapon pistol = factory.getWeapon("GLOCK19");
        }
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("FactoryMethod" + timeElapsed + " ms");

        // Abstract Factory
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            WeaponAbstractFactory abstractFactory = CivilWeaponFactory.getInstance();
            Pistol civilPistol = abstractFactory.assemblePistol();
        }
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("AbstractFactory" + timeElapsed + " ms");

        // ReflectionFactory
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            ReflectionFactory factory = ReflectionFactory.getInstance();
            factory.registerWeapon("GLOCK19", Glock19.class);
            Weapon pistol = factory.assembleWeapon("GLOCK19");
        }
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("ReflectionFactory" + timeElapsed + " ms");

        // NoReflectionFactory
        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            NoReflectionFactory factory = NoReflectionFactory.getInstance();
            factory.registerType("GLOCK19", Glock19::new);
            Weapon pistol = factory.getProduct("GLOCK19");
        }
        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("NoReflectionFactory" + timeElapsed + " ms");
    }
}
