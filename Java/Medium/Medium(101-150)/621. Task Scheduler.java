/*
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example 1:
Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
Note:
The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
*/
class Solution {
    // solution from:https://leetcode.com/problems/task-scheduler/discuss/154448/Java-very-ver-short-code-using-PriorityQueue
     public static int leastInterval(char[] tasks, int n) {
        // map[ch-'A'] is the earliest time that the next task "ch" can be executed
            int[] map = new int[26];  
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int c : tasks) {
                queue.offer(map[c-'A']);
                map[c-'A'] += n + 1;
            }
            int res = 0;
            while (!queue.isEmpty()) {
                int t = queue.poll();
                // if current time is later than the earliest executed time, use the current time, 
                // otherwise, the current time should be set as that earliest executed time
                res = res > t ? res : t;
                res++;
            }
            return res;
     }
}