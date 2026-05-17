import java.util.Arrays;

public class FibonacciNumber {
//    public static int fib(int n) {
//        int[] dp = new int[n+1];
//        if (n == 0) {
//            return 0;
//        }
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i-1] + dp[i-2];
//        }
////        System.out.println(Arrays.toString(dp));
//        return dp[n];
//    }

    public static int fib(int n) {
        if (n == 0 || n == 1) return n;
        int prev2 = 0,prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
