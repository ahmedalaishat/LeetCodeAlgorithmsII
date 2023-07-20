package interval_list_intersections_986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ahmed Al-Aishat on Jul/20/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}})));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int firstPtr = 0;
        int secondPtr = 0;
        List<int[]> result = new ArrayList<>();
        while (firstPtr < firstList.length && secondPtr < secondList.length) {
            if (firstList[firstPtr][1] < secondList[secondPtr][0]) firstPtr++;
            else if (secondList[secondPtr][1] < firstList[firstPtr][0]) secondPtr++;
            else {
                result.add(new int[]{Math.max(firstList[firstPtr][0], secondList[secondPtr][0]), Math.min(firstList[firstPtr][1], secondList[secondPtr][1])});
                if (secondList[secondPtr][1] < firstList[firstPtr][1]) secondPtr++;
                else firstPtr++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
