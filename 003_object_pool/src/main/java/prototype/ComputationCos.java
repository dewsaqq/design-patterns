package prototype;

public class ComputationCos implements ComputationPrototype {
    public double result = 0;
    public double[] nums;

    public ComputationCos() {
        nums = new double[2000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.sin(Math.pow(i,2));
    }

    public ComputationCos(double result, double[] nums) {
        this.result = result;
        this.nums = nums;
    }

    public double compute(int i) {
        result = Math.cos(Math.atan(Math.sqrt(Math.pow(nums[i], 3))));
        return result;
    }

    @Override
    public ComputationPrototype clone() {
        try {
            return (ComputationCos)super.clone();
        } catch (CloneNotSupportedException e) {
            return new ComputationCos(this.result, this.nums);
        }
    }

    @Override
    public void reset() {
        result = 0;
    }
}
