package task47;

/*
DESCRIPTION:
    Write a function called sumIntervals/sum_intervals that accepts an array of intervals,
    and returns the sum of all the interval lengths. Overlapping intervals should only be counted once.

    Intervals
    Intervals are represented by a pair of integers in the form of an array.
    The first value of the interval will always be less than the second value. Interval example:
     [1, 5] is an interval from 1 to 5. The length of this interval is 4.

    Overlapping Intervals
    List containing overlapping intervals:

    [
      [1, 4],
      [7, 10],
      [3, 5]
    ]
    The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval
    as [1, 5], which has a length of 4.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int result = 0;
        int currentEnd = intervals[0][0];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (end > currentEnd) {
                result += end - Math.max(start, currentEnd);
                currentEnd = end;
            }
        }
        return result;
    }
}