/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0,
and to take course 0 you should also have finished course 1. So it is impossible.
*/


//topological sort
//either BFS or dfs

//BFS
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<Integer>();
        int count = numCourses;
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            indegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i : map.get(current)) {
                if (--indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            count--;
        }
        return count == 0;
    }
}

// dfs maybe a little bit easier to understand? recursive
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfsDetectCycle(graph, visited, i)) return false;// 0: White
        }
        return true;
    }
    
    private boolean dfsDetectCycle(List<List<Integer>> graph, int[] visited, int prere) {
        visited[prere] = -1; //-1: Gray
        for (Integer course: graph.get(prere)) {
            if (visited[course] == -1) return true;
            else if (visited[course] == 0 && dfsDetectCycle(graph, visited, course)) return true;
        }
        visited[prere] = 1; //1: Black
        return false;
    }
}
