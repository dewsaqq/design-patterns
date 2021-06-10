import builder.*;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComputationTimeTest {
    private int numberOfIterations = 10000;

    @Test
    public void computationMaxTimeTest() {
        long startTime, endTime, timeElapsed;

        Builder builder = new ThreadBuilderMax();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfIterations);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            ThreadDirector director = new ThreadDirector();
            director.construct(builder);
            PoolThread worker = builder.getPoolThread();
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) { }

        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Pool with Max objects: " + timeElapsed + " ms");
    }

    @Test
    public void computationTimeTest() {
        long startTime, endTime, timeElapsed;

        Builder builder = new ThreadBuilder();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfIterations);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < numberOfIterations; i++) {
            ThreadDirector director = new ThreadDirector();
            director.construct(builder);
            PoolThread worker = builder.getPoolThread();
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) { }

        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("Pool with creation when needed: " + timeElapsed + " ms");
    }

    @Test
    public void computationTimeWithoutPoolTest() {
        long startTime, endTime, timeElapsed;
        ExecutorService executor = Executors.newFixedThreadPool(numberOfIterations);

        startTime = System.currentTimeMillis();

        for (int i = 0; i < numberOfIterations; i++) {
            NoPoolThread thread = new NoPoolThread();
            executor.execute(thread);
        }

        executor.shutdown();
        while (!executor.isTerminated()) { }

        endTime = System.currentTimeMillis();
        timeElapsed = endTime - startTime;
        System.out.println("No Pool time: " + timeElapsed + " ms");
    }

}
