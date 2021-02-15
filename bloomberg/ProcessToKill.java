import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**

Given n processes, each process has a unique PID (process id) and its PPID (parent process id).

Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. 
Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.

We use two list of integers to represent a list of processes, where the first list contains PID 
for each process and the second list contains the corresponding PPID.

Now given the two lists, and a PID representing a process you want to kill, return a 
list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, 
all its children processes will be killed. No order is required for the final answer.

Example 1:
Input: 
pid =  [1, 3, 10, 5]
ppid = [3, 0, 5, 3]
kill = 5
Output: [5,10]
Explanation: 
           3
         /   \
        1     5
             /
            10
Kill 5 will also kill 10.
Note:
The given kill id is guaranteed to be one of the given PIDs.
n >= 1.


**/

public class ProcessToKill {
	 public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int i = 0;
        for(int key : ppid){
        	if(!map.containsKey(key)){
        		map.put(key, new ArrayList<>());
        	}
        	map.get(key).add(pid.get(i));
        	i++;
        }
        List<Integer> result = new ArrayList<>();
        dfs(map, kill, result);
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> map, Integer parent, List<Integer> result){
    	result.add(parent);
    	if(map.containsKey(parent)){
    		for(Integer child : map.get(parent)){
    			dfs(map, child, result);
    		}
    	}
    }
	public static void main(String[] args) {
		ProcessToKill pk = new ProcessToKill();
		List<Integer> pid = new ArrayList<>();
		pid.add(1);
		pid.add(3);
		pid.add(10);
		pid.add(5);
		List<Integer> ppid = new ArrayList<>();
		ppid.add(3);
		ppid.add(0);
		ppid.add(5);
		ppid.add(3);
		int kill = 5;
		System.out.println("last process list "+pk.killProcess(pid, ppid, kill));
	}
}