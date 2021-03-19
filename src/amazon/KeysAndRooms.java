package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *
 * There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 *
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 *
 * Initially, all the rooms start locked (except for room 0).
 *
 * You can walk back and forth between rooms freely.
 *
 * Return true if and only if you can enter every room.
 *
 * Example 1:
 *
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 *
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 *
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 *
 */

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while(!stack.isEmpty()){
            int room = stack.pop();
            for(int key : rooms.get(room)){
                if(!seen[key]){
                    seen[key] = true;
                    stack.push(key);
                }
            }
        }
        for(boolean key : seen )
            if(!key) return false;
        return true;
    }
    public static void main(String[] args) {
        KeysAndRooms kr = new KeysAndRooms();
        List<Integer> room0 = new ArrayList<>();
        List<List<Integer>> rooms = new ArrayList<>();
        room0.add(1);
        room0.add(3);
        rooms.add(room0);
        List<Integer> room1 = new ArrayList<>();
        room1.add(3);
        room1.add(0);
        room1.add(1);
        rooms.add(room1);
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        rooms.add(room2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(0);
        rooms.add(room3);
        System.out.println("Can visit all rooms :"+kr.canVisitAllRooms(rooms));
    }
}
