package builder;

import prototype.ComputationType;

public abstract class Builder {
    protected PoolThread poolThread = new PoolThread();
    public abstract void createObjectPool();
    public abstract void setRandomNumber();
    public abstract void setComputationType(ComputationType type);
    public PoolThread getPoolThread() {
        return poolThread;
    }
}
