import java.util.Arrays;

public class CoinChange {
    // Implement Approach 1 : Memoization
    private static int[] memo;
    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-2);
        return helper(coins, amount);
    }

    private static int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (memo[amount] != -2) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = helper(coins,amount - coin);
            if (sub != -1) {
                min = Math.min(min,sub+1);
            }
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }

    // Implement Approach 2 : Tabulation

//    public static int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0] = 0;
//
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (coin <= i) {
//                    dp[i] = Math.min(dp[i],dp[i-coin] + 1 );
//                }
//            }
//        }
//
//        return dp[amount] > amount ? -1 : dp[amount];
//    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }
}
