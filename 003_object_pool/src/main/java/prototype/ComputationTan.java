package prototype;

public class ComputationTan implements ComputationPrototype {
    public double result = 0;
    public double[] nums;

    public ComputationTan() {
        nums = new double[2000];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.cos(Math.sqrt(i));
    }

    public ComputationTan(double result, double[] nums) {
        this.result = result;
        this.nums = nums;
    }

    public double compute(int i) {
        result = Math.atan2(Math.atan(Math.sqrt(Math.sqrt(nums[i]))), Math.sqrt(nums[i]));
        return result;
    }

    @Override
    public ComputationPrototype clone() {
        try {
            return (ComputationTan)super.clone();
        } catch (CloneNotSupportedException e) {
            return new ComputationTan(this.result, this.nums);
        }
    }

    @Override
    public void reset() {
        result = 0;
    }
}
