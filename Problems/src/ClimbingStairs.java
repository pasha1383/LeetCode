import java.util.Arrays;

public class ClimbingStairs {
//    public static int climbStairs(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//        return dp[n];
//    }

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int prev2 = 1,prev1 = 1;

        for (int i = 2; i <=n ; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }


}
