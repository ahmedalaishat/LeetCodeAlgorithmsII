package decode_ways_91;

/**
 * Created by Ahmed Al-Aishat on Jul/30/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

//    Map<String, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
        System.out.println(new Solution().numDecodings("226"));
        System.out.println(new Solution().numDecodings("06"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] ways = new int[n + 1];
        ways[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ways[i] = 0;
            } else {
                ways[i] = ways[i + 1];
                if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) <= '6')) {
                    ways[i] += ways[i + 2];
                }
            }
        }
        return ways[0];
    }

//    int[] saved;
//
//    public int numDecodings(String s) {
//        saved = new int[s.length()];
//        return numDecodings(s.toCharArray(), 0);
//    }
//
//    public int numDecodings(char[] chars, int start) {
//        if (start >= chars.length) return 1;
//
//        if (saved[start] > 0) return saved[start];
//
//        int oneDigit = chars[start] - '0';
//
//        if (oneDigit == 0) return 0;
//
//        if (start == chars.length - 1) {
//            var ways = numDecodings(chars, start + 1);
//            saved[start] = ways;
//            return ways;
//        }
//
//        int twoDigits = oneDigit * 10 + chars[start + 1] - '0';
//
//        if (twoDigits > 26) {
//            var ways = numDecodings(chars, start + 1);
//            saved[start] = ways;
//            return ways;
//        }
//
//
//        var ways = numDecodings(chars, start + 1) + numDecodings(chars, start + 2);
//        saved[start] = ways;
//        return ways;
//    }
}
