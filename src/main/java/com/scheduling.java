package com;

import java.util.*;


public class scheduling {

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null)
            return false;
        SortedSet<int[]> sortedSet = new TreeSet<>(Comparator.comparingInt(interval -> interval[0]));
        for (int[] interval : intervals) {
            sortedSet.add(interval);
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
        intervals = new int[][]{{3, 5}, {1, 2}, {5, 6}};
        System.out.printf(" Can "+ sc.canAttendMeetings(intervals));
    }
}
