package builder;

import pool.ObjectPool;
import prototype.ComputationPrototype;
import prototype.ComputationType;

public class PoolThread implements Runnable {
    public ObjectPool objectPool;
    public int number;
    public ComputationType type;

    public void run() {
        ComputationPrototype computation = objectPool.getComputation();
        computation.compute(number);
        objectPool.releaseComputation(computation);
    }
}
