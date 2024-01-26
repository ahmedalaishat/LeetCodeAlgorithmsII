package longest_palindromic_substring_5;

/**
 * Created by Ahmed Al-Aishat on Jul/28/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().longestPalindrome("aacabdkacaa"));
//        System.out.println(new Solution().longestPalindrome("bb"));
        System.out.println(new Solution().longestPalindrome("babad"));
    }


    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i ++) {
            int left = i;
            int right = i;
            while(left >= 0 && s.charAt(left) == s.charAt(i)) left --;
            while(right < s.length() && s.charAt(right) == s.charAt(i)) right ++;
            while(left >= 0 && right < s.length()) {
                if(s.charAt(left) != s.charAt(right)) break;
                left --;
                right ++;
            }
            left += 1;
            if(end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end);
    }

//    public String longestPalindrome(String s) {
//        var chars = s.toCharArray();
//        var ans = String.valueOf(chars[0]);
//        for (int start = 0; start < chars.length; start++) {
//            if (ans.length() > chars.length - start) break;
//            var end = chars.length - 1;
//            while (true) {
//                end = s.lastIndexOf(chars[start], end);
//                if (ans.length() >= end - start + 1) break;
//                if (isPalindromic(chars, start, end)) ans = new String(chars, start, end - start + 1);
//                end--;
//            }
//        }
//        return ans;
//    }
//
//    private boolean isPalindromic(char[] chars, int start, int end) {
//        while (start < end) if (chars[start++] != chars[end--]) return false;
//        return true;
//    }
//
}
