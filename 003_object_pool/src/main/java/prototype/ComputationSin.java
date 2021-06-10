package prototype;

public class ComputationSin implements ComputationPrototype {
    public double result = 0;
    public double[] nums;

    public ComputationSin() {
        nums = new double[2000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.pow(i,2);
    }

    public ComputationSin(double result, double[] nums) {
        this.result = result;
        this.nums = nums;
    }

    public double compute(int i) {
        result = Math.sin(Math.abs(nums[i]));
        return result;
    }

    @Override
    public ComputationPrototype clone() {
        try {
            return (ComputationSin)super.clone();
        } catch (CloneNotSupportedException e) {
            return new ComputationSin(this.result, this.nums);
        }
    }

    @Override
    public void reset() {
        result = 0;
    }
}
