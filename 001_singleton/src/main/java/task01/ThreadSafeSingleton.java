package task01;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton uniqueInstance;

    private ThreadSafeSingleton() { }

    public static ThreadSafeSingleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (ThreadSafeSingleton.class) {
                uniqueInstance = new ThreadSafeSingleton();
            }
        }
        return uniqueInstance;
    }

}
