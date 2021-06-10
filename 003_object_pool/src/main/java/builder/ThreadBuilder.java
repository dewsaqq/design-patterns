package builder;

import pool.ObjectPool1;
import prototype.ComputationType;

import java.util.Random;

public class ThreadBuilder extends Builder {
    @Override
    public void createObjectPool() {
        poolThread.objectPool = ObjectPool1.getInstance();
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
