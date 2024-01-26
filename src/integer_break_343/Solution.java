package integer_break_343;

/**
 * Created by Ahmed Al-Aishat on Aug/01/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(6));
    }


    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = (int) Math.pow(3, ((int) (n / 3)));
        if (n % 3 == 2) product *= 2;
        else if (n % 3 == 1) product = product / 3 * 4;
        return product;
    }

    public int longestCommonSubsequence(String text1, String text2) {
        return 0;
    }
}
