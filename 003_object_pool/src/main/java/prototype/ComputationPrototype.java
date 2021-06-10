package prototype;

public interface ComputationPrototype extends Cloneable {
    double compute(int number);
    void reset();
    ComputationPrototype clone();
}