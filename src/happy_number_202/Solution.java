package happy_number_202;

/**
 * Created by Ahmed Al-Aishat on Aug/05/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(new Solution().isHappy(2));
    }

    public boolean isHappy(int n) {
        // use this to know the previous sum, so we can detect if there is an endless cycle
        boolean[] sums = new boolean[731]; // the max sum is sum of '1999999999' which is 1^2 + (9^2) * 9 = 730
        while (true) {
            int sum = 0;
            while (n > 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (sum == 1) return true;
            if (sums[sum]) return false;
            sums[sum] = true;
            n = sum;
        }
    }
}
