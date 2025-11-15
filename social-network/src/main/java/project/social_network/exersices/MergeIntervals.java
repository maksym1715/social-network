package project.social_network.exersices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {

    }



    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(new int[]{intervals[0][0], intervals[0][1]});

        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];

            if (cur[0] <= last[1]) {              // overlap
                last[1] = Math.max(last[1], cur[1]);
            } else {
                res.add(new int[]{cur[0], cur[1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }


}

//
//
//Given an array of intervals where intervals[i] = [starti, endi],
//merge all overlapping intervals, and return an array
//of the non-overlapping intervals that
//cover all the intervals in the input.
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].