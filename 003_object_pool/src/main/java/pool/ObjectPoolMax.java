package pool;

import prototype.ComputationPrototype;
import prototype.ComputationPrototypeManager;
import prototype.ComputationType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ObjectPoolMax implements ObjectPool {
    public static final int MAX_POOL_SIZE = 20;
    private static ObjectPoolMax instance = null;

    public static BlockingQueue<ComputationPrototype> queue = new ArrayBlockingQueue<>(MAX_POOL_SIZE);

    public static synchronized ObjectPoolMax getInstance() {
        if (instance == null) {
            instance = new ObjectPoolMax();
        }
        return instance;
    }

    public synchronized ComputationPrototype getComputation() {
        ComputationPrototype computation = null;
        if (queue.size() < MAX_POOL_SIZE) {
            ComputationPrototypeManager manager = new ComputationPrototypeManager();
            computation = manager.getPrototype(ComputationType.COS);
            queue.add(computation);
        } else {
            try {
                computation = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return computation;
    }

    public synchronized void releaseComputation(ComputationPrototype computation) {
        reset(computation);
        if (queue.size() < MAX_POOL_SIZE) {
            queue.add(computation);
        }
    }

    public static void reset(ComputationPrototype computation) {
        computation.reset();
    }
}
