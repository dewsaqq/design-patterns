package builder;

import prototype.ComputationPrototype;
import prototype.ComputationPrototypeManager;
import prototype.ComputationType;

import java.util.Random;

public class NoPoolThread implements Runnable {
    public void run() {
        ComputationPrototypeManager manager = new ComputationPrototypeManager();
        ComputationPrototype computation = manager.getPrototype(ComputationType.COS);
        Random random = new Random();
        computation.compute(random.nextInt(1000));
    }
}
