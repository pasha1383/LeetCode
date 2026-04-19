import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        int[] nums = {4,7,11,15};
        int target = 19;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums,int target) {
        int fp = 0;
        int sp = nums.length - 1;
        int total;
        while (fp < sp) {
            total = nums[fp] + nums[sp];
            if (total < target) {
                fp++;
            }else if (total > target) {
                sp--;
            }else {
                break;
            }
        }
        return new int[] {fp + 1,sp + 1};
    }
}
