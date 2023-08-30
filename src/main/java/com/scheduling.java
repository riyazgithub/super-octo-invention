package com;

import java.util.*;


public class scheduling {

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null)
            return false;
        SortedSet<int[]> sortedSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0] >=0 ? 1 : -1; // Compare based on start times
            }
        });

        for (int[] interval : intervals) {
            sortedSet.add(interval);
        }
        for (int[] interval : sortedSet) {
            System.out.println(Arrays.toString(interval));
        }

        ArrayList<int[]> ll = new ArrayList<>(sortedSet);
        for (int i =1; i<ll.size(); i++) {
            if(ll.get(i)[0] < ll.get(i-1)[1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] intervals = {{3, 5}, {1, 2}, {4, 6}};
        scheduling sc = new scheduling();
        System.out.printf(" Can "+ sc.canAttendMeetings(intervals));
        intervals = new int[][]{{9, 10}, {4, 9}, {4, 17}};
        System.out.println();
        System.out.printf(" Can "+ sc.canAttendMeetings(intervals));
    }
}
