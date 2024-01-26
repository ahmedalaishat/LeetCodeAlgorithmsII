package coin_change_322;

/**
 * Created by Ahmed Al-Aishat on Aug/05/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{470, 18, 66, 301, 403, 112, 360}, 8235));
    }

    int[] count;

    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        count = new int[amount + 1];
        return helper(coins, amount);
    }

    private int helper(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount] != 0) return count[amount];
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = helper(coins, amount - coin);
            if (result >= 0 && result < min) min = 1 + result;
        }

        count[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount];
    }
}
