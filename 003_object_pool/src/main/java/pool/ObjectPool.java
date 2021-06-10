package pool;

import prototype.ComputationPrototype;

public interface ObjectPool {
    ComputationPrototype getComputation();
    void releaseComputation(ComputationPrototype object);
}
