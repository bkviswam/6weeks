package com.facebook;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindClosestElements {
    /**
     * public List<Integer> findClosestElements(int[] arr, int k, int x) {
     * return IntStream.of(arr).boxed().sorted((a,b)->a==b?a-b:Math.abs(a-x)-Math.abs(b-x)).limit(k).sorted().collect(Collectors.toList());
     * }
     **/
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(x - arr[i]);
            if (!map.containsKey(diff)) {
                map.put(diff, new PriorityQueue<>());
            }
            map.get(diff).offer(arr[i]);
        }
        PriorityQueue<Integer> key = new PriorityQueue();
        for (int p : map.keySet()) {
            key.add(p);
        }
        ArrayList<Integer> ans = new ArrayList();
        int cnt = 0;
        while (cnt != k) {
            int a = key.poll();
            PriorityQueue<Integer> list = map.get(a);
            while (cnt != k && list.size() > 0) {
                result.add(list.poll());
                cnt++;
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        FindClosestElements ce = new FindClosestElements();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 4;
        int x = -1;
        System.out.println(ce.findClosestElements(arr, k, x));
    }
}
