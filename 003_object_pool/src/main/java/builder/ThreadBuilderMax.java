package builder;

import pool.ObjectPoolMax;
import prototype.ComputationType;

import java.util.Random;

public class ThreadBuilderMax extends Builder {
    @Override
    public void createObjectPool() {
        poolThread.objectPool = ObjectPoolMax.getInstance();
    }

    @Override
    public void setRandomNumber() {
        Random random = new Random();
        poolThread.number = random.nextInt(1000);
    }

    @Override
    public void setComputationType(ComputationType type) {
        poolThread.type = type;
    }
}
