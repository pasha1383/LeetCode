// 53
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        return maxSubArrayRec(nums,0, nums.length-1);
    }

    private int maxSubArrayRec(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + (hi - lo)/2;

        int leftMax = maxSubArrayRec(nums, lo, mid);
        int rightMax = maxSubArrayRec(nums, mid+1, hi);

        int crossMax = maxCrossingSum(nums,lo,mid,hi);

        return Math.max(Math.max(leftMax,rightMax),crossMax);
    }

    private int maxCrossingSum(int[] nums, int lo, int mid, int hi) {
        int sum =0;
        int leftMaxPart = Integer.MIN_VALUE;
        for (int i = mid; i >= lo; i--) {
            sum += nums[i];
            leftMaxPart = Math.max(leftMaxPart,sum);
        }


        sum = 0;
        int rightMaxPart = Integer.MIN_VALUE;
        for (int i = mid+1; i <= hi; i++) {
            sum += nums[i];
            rightMaxPart = Math.max(rightMaxPart,sum);
        }

        return rightMaxPart + leftMaxPart;
    }
}
