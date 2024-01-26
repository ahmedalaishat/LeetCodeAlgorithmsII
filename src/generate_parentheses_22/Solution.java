package generate_parentheses_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/27/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
    }

    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generateParenthesis(n, 0, 0, new StringBuilder());
        return ans;
    }

    public void generateParenthesis(int n, int open, int close, StringBuilder builder) {
        if (close > open || open > n) return;
        if (open == n && close == n) {
            ans.add(builder.toString());
            return;
        }
        builder.append('(');
        generateParenthesis(n, open + 1, close, builder);
        builder.deleteCharAt(builder.length() - 1);
        if (open > close) {
            builder.append(')');
            generateParenthesis(n, open, close + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
