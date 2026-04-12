import java.util.HashSet;
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num:nums) set.add(num);
        int best = 0;
        for (int num:nums) {
            if (!set.contains(num-1)) {
                int current = num;
                int len = 1;
                while (set.contains(++current)){
                    len++;
                }
                best = Math.max(best,len);
            }
        }

        return best;
    }
}
