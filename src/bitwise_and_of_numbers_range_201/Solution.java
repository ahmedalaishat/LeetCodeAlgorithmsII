package bitwise_and_of_numbers_range_201;

/**
 * Created by Ahmed Al-Aishat on Aug/05/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(1, 2147483647));
    }

    /**
     * Only the common bits sequence from left will not change after applying AND for the range numbers
     */
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) return left;
        int a = 0x40000000;
        int bitsCount = 31;
        while ((a & left) == (a & right)) {
            a >>>= 1;
            bitsCount--;
        }
        return (Integer.MAX_VALUE << bitsCount) & left; //
    }
}
