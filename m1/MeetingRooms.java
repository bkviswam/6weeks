import java.util.Arrays;

/**

252. Meeting Rooms

Share
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false
Example 2:

Input: [[7,10],[2,4]]
Output: true
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.



**/

public class MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
		for(int i=0; i <intervals.length -1; i++ ){
			if(intervals[i][1]>intervals[i+1][0]){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		MeetingRooms mr = new MeetingRooms();
		//int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
		int[][] intervals = new int[][]{{7,10},{2,4},{5,6}};
		System.out.println("Can person attend all meetings?: "+mr.canAttendMeetings(intervals));
	}
}