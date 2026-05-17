import java.util.Arrays;

public class CountingBits {

    public static int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
