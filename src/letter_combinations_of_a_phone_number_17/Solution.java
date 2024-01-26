package letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        return letterCombinations(digits, 0);
    }

    public List<String> letterCombinations(String digits, int start) {
        if (start == digits.length()) return List.of("");

        var ans = new ArrayList<String>();
        var currentCombinations = getLetterCombinationsOfDigit(digits.charAt(start));
        var nextCombinations = letterCombinations(digits, start + 1);

        for (char current : currentCombinations)
            for (String next : nextCombinations)
                ans.add(current + next);

        return ans;
    }

    private char[] getLetterCombinationsOfDigit(char c) {
        if (c == '2') return new char[]{'a', 'b', 'c'};
        if (c == '3') return new char[]{'d', 'e', 'f'};
        if (c == '4') return new char[]{'g', 'h', 'i'};
        if (c == '5') return new char[]{'j', 'k', 'l'};
        if (c == '6') return new char[]{'m', 'n', 'o'};
        if (c == '7') return new char[]{'p', 'q', 'r', 's'};
        if (c == '8') return new char[]{'t', 'u', 'v'};
        if (c == '9') return new char[]{'w', 'x', 'y', 'z'};
        return new char[]{};
    }
}
