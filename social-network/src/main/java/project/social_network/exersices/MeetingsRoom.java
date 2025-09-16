package project.social_network.exersices;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingsRoom {
    public static void main(String[] args) {

    }


    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer>priorityQueue=new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (!priorityQueue.isEmpty() && interval[0]>=priorityQueue.peek()){
                 priorityQueue.poll();
            }
            priorityQueue.offer(interval[1]);
        }
        return priorityQueue.size();
    }

}
