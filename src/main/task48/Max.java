package task48;
/*
DESCRIPTION:
        The maximum sum subarray problem consists in finding the maximum sum of a contiguous
        subsequence in an array or list of integers:

        Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
// should be 6: {4, -1, 2, 1}
        Easy case is when the list is made up of only positive numbers and the maximum sum
        is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.

        Empty list is considered to have zero greatest sum. Note that the empty list
        or array is also a valid sublist/subarray.
*/

public class Max {
    public static int sequence(int[] arr) {
        if (arr.length == 0) return 0;
        int max = arr[0], sum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > sum + arr[i])
                sum = arr[i];
            else
                sum += arr[i];
            if (max < sum)
                max = sum;
        }
        if (max < 0) return 0;
        return max;
    }
}

