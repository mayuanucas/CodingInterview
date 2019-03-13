package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: mayuan
 * @desc: 课程表 II
 * @date: 2019/03/13
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return null;
        }
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        int index = 0;
        // Indegree - how many prerequisites are needed.
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        }
        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            // Already finished this prerequisite course.
            int prerequisite = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return (index == numCourses) ? order : new int[0];
    }
}
