package word_break_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ahmed Al-Aishat on Jul/30/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }

    boolean[] notExist;

    public boolean wordBreak(String s, List<String> wordDict) {
        notExist = new boolean[s.length()];
        // put all words into a hashset
        Set<String> set = new HashSet<>(wordDict);
        return wordBreak(s, 0, set);
    }

    public boolean wordBreak(String s, int index, Set<String> wordDict) {
        if (s.isEmpty()) return true;
        if (notExist[index]) return false;

        for (int i = s.length(); i > 0; i--)
            if (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), index + i, wordDict))
                return true;

        notExist[index] = true;
        return false;
    }
}
