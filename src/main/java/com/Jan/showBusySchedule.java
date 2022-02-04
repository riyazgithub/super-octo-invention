package com.Jan;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class showBusySchedule {
    public static void main(String[] args) {
        int[][] meetingTimes1 = {{1, 4}, {2, 5}, {6, 8}, {7, 9}, {10, 13}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes1)));
        int[][] meetingTimes2 = {{4, 7}, {1, 3}, {8, 10}, {2, 3}, {6, 8}};
        System.out.println(Arrays.deepToString(mergeMeetings(meetingTimes2)));
    }

    public static int[][] mergeMeetings(int[][] meetingTimes) {
        Arrays.sort(meetingTimes, (a,b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        for (int[] meeting : meetingTimes) {
            int size = merged.size();
            if(size == 0 || merged.get(size-1)[1] < meeting[0] ) {
                merged.add(meeting);
            }
            else {
                merged.get(size-1)[1] = Math.max(merged.get(size-1)[1], meeting[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
