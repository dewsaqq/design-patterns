package task04;

public class ThreadLocalSingleton {
    private ThreadLocalSingleton() { }

    private static ThreadLocal<ThreadLocalSingleton> _threadLocal =
            ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    public static ThreadLocalSingleton getInstance() {
        return _threadLocal.get();
    }
}
