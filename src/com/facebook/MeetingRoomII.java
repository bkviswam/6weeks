package com.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 * <p>
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= intervals.length <= 104
 * 0 <= starti < endi <= 106
 */

public class MeetingRoomII {
    public int minMeetingRoom(int[][] intervals) {
        int result = 1;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = heap.peek();
            if (intervals[i][0] < top[1]) {
                result++;
            } else {
                heap.remove();
            }
            heap.add(intervals[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        MeetingRoomII mr = new MeetingRoomII();
        int[][] intervals = new int[][]{{0, 30}, {5, 10}, {15, 20}};
        System.out.println("Number of meeting rooms required :" + mr.minMeetingRoom(intervals));
    }
}
