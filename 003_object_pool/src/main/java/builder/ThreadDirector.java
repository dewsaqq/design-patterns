package builder;

import prototype.ComputationType;

public class ThreadDirector {
    public void construct(Builder builder) {
        builder.createObjectPool();
        builder.setRandomNumber();
        builder.setComputationType(ComputationType.COS);
    }
}
