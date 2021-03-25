package com.facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 870. Advantage Shuffle
 *
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 *
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 *
 * Note:
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageShuffle {
    public int[] advantageCount(int[] A, int[] B) {
        int[] TJSM = new int[A.length];
        Arrays.sort(A);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < B.length; i++) {
            maxHeap.offer(new int[]{i, B[i]});
        }
        int slow = 0;
        int fast = A.length-1;
        while (!maxHeap.isEmpty()) {
            int[] b = maxHeap.poll();
            TJSM[b[0]] = b[1] >= A[fast] ? A[slow++] : A[fast--];
        }
        return TJSM;
    }
    public static void main(String[] args) {
        AdvantageShuffle as = new AdvantageShuffle();
        int[] A = new int[]{2, 7, 11, 15};
        int[] B = new int[]{1, 10, 4, 11};
        System.out.println(Arrays.toString(as.advantageCount(A, B)));
    }
}
