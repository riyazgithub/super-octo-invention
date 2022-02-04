package com.Jan;


import java.util.Arrays;
        import java.util.PriorityQueue;
class findMeetingRoom {

    public static int minMeetingRooms(int[][] meetingTimes){

        if(meetingTimes.length == 0){
            return 0;
        }

        Arrays.sort(meetingTimes, (a, b) -> Integer.compare(a[0], b[0]));
        //min Heap keeps track of earliest ending meeting:
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((A, B) -> A - B);

        minHeap.add(meetingTimes[0][1]);

        for (int i = 1; i < meetingTimes.length; i++) {
            int currStart = meetingTimes[i][0];
            int currEnding = meetingTimes[i][1];
            int earliestEnding = minHeap.peek();

            if (earliestEnding <= currStart) {
                minHeap.remove();
            }
            //update heap with curr ending
            minHeap.add(currEnding);
        }
        return minHeap.size();
    }

    public static void main( String args[] ) {
        // Driver code
        int[][] meetingTimes = {{2, 8}, {3, 4}, {3, 9}, {5, 11}, {8, 20}, {11, 15}};
        System.out.print(minMeetingRooms(meetingTimes));
    }
}