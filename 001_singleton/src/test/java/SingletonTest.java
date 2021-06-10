import task01.ThreadSafeSingleton;
import task04.ThreadLocalSingleton;
import org.junit.*;
import task02.*;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {
    Singleton doubleSingleton = DoubleSingleton.getInstance();
    Singleton tripleSingleton = TripleSingleton.getInstance();

    @Test
    public void inheritedSingletonsTest() {
        assertThat(doubleSingleton.hashCode()).isEqualTo(tripleSingleton.hashCode());
    }

    @Test
    public void threadSafeSingletonTest() {
        boolean areSameInstances = true;

        for(int i = 0; i < 50; i++) {
            ThreadSafeRunner runner = new ThreadSafeRunner();
            Thread thread = new Thread(runner);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!runner.areInstancesEqual()) areSameInstances = false;
        }

        assertThat(areSameInstances).isEqualTo(true);
    }

    @Test
    public void oneSingletonPerThreadTest() {
        for(int i = 0; i < 3; i++) {
            LocalThreadRunner runner = new LocalThreadRunner();
            Thread thread = new Thread(runner);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean value = runner.areInstancesEqual();

            assertThat(value).isEqualTo(true);
        }
    }
}

class LocalThreadRunner implements Runnable {
    private volatile boolean areInstancesEqual;

    @Override
    public void run() {
        ThreadLocalSingleton inst1 = ThreadLocalSingleton.getInstance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadLocalSingleton inst2 = ThreadLocalSingleton.getInstance();
        areInstancesEqual = inst1.hashCode() == inst2.hashCode();
    }

    public boolean areInstancesEqual() {
        return areInstancesEqual;
    }
}

class ThreadSafeRunner implements Runnable {
    private volatile boolean areInstancesEqual;

    @Override
    public void run() {
        ThreadSafeSingleton inst1 = ThreadSafeSingleton.getInstance();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ThreadSafeSingleton inst2 = ThreadSafeSingleton.getInstance();
        areInstancesEqual = inst1.hashCode() == inst2.hashCode();
    }

    public boolean areInstancesEqual() {
        return areInstancesEqual;
    }
}
