package max_points_on_a_line_149;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Ahmed Al-Aishat on Aug/05/2023.
 * LeetCode Algorithm II Project.
 */
public class Solution {

    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
//        java.util.Arrays.sort(arr, new java.util.Comparator<int[]>() {
//            public int compare(int[] a, int[] b) {
//                return Double.compare(a[0], b[0]);
//            }
//        });
//        System.out.println(Arrays.deepToString(arr));
        System.out.println(new Solution().maxPoints(new int[][]{{4, 5}, {4, -1}, {4, 0}}));
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }

    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;

        // sort depending on x, so for any two points we can compare only the points between them
        Arrays.sort(points, Comparator.comparingDouble(a -> a[0]));

        int max = 2;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 2; j < points.length; j++) {

                int count = 2; // the current tow points
                int[] left = points[j];
                int[] right = points[i];

                double m1; // calculate m1 = (y2 - y1) / (x2 - x1)
                if (right[0] == left[0]) m1 = Double.POSITIVE_INFINITY;
                else m1 = (right[1] - left[1]) / (double) (right[0] - left[0]);

                for (int k = i + 1; k < j; k++) {
                    int[] middle = points[k];

                    double m2;
                    if (middle[0] == left[0]) m2 = Double.POSITIVE_INFINITY;
                    else m2 = (middle[1] - left[1]) / (double) (middle[0] - left[0]);

                    // add point if it has the same m
                    if (m1 == m2) count++;
                }
                if (count > max) max = count;
            }
        }
        return max;
    }
}
