// 169

public class MajorityElement {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0, nums.length-1);
    }

    private int majorityElementRec(int[] nums,int lo,int hi) {
        if (lo > hi) {
            return -1;
        }

        if (lo == hi) {
            return nums[lo];
        }

        int mid = lo + (hi-lo)/2;

        int left = majorityElementRec(nums, lo, mid-1);
        int right = majorityElementRec(nums, mid+1, hi);

        if (left == right) {
            return left;
        }

        int leftCount = countInRange(nums,left,lo,hi);
        int rightCount = countInRange(nums,right,lo,hi);

        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums,int number,int left,int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == number) {
                count++;
            }
        }

        return count;
    }
}
