package pool;

import prototype.ComputationPrototype;
import prototype.ComputationPrototypeManager;
import prototype.ComputationType;

import java.util.concurrent.CopyOnWriteArrayList;

public class ObjectPool1 implements ObjectPool {
    private static ObjectPool1 instance = null;

    public static CopyOnWriteArrayList<ComputationPrototype> available = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<ComputationPrototype> inUse = new CopyOnWriteArrayList<>();

    public static synchronized ObjectPool1 getInstance() {
        if (instance == null) {
            instance = new ObjectPool1();
        }
        return instance;
    }

    public synchronized ComputationPrototype getComputation() {
        ComputationPrototype computation;
        if (!available.isEmpty()) {
            computation = available.get(0);
            available.remove(0);
        } else {
            ComputationPrototypeManager manager = new ComputationPrototypeManager();
            computation = manager.getPrototype(ComputationType.COS);
        }
        inUse.add(computation);
        return computation;
    }

    @Override
    public synchronized void releaseComputation(ComputationPrototype computation) {
        reset(computation);
        available.add(computation);
        inUse.remove(computation);
    }

    public static void reset(ComputationPrototype computation) {
        computation.reset();
    }
}
