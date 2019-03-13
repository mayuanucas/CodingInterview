package algorithm.leetcode;

import java.util.LinkedList;

/**
 * @author: mayuan
 * @desc: 课程表
 * @date: 2019/03/13
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // matrix[i][j]=1 表示 第i门课是第j门课的先行课
        int[][] matrix = new int[numCourses][numCourses];
        // indegree[i] 表示第i个课程有几门先行课
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; ++i) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (0 == matrix[pre][ready]) {
                ++indegree[ready];
            }
            matrix[pre][ready] = 1;
        }

        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; ++i) {
            if (0 == indegree[i]) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.pollFirst();
            ++count;
            for (int i = 0; i < numCourses; ++i) {
                if (0 != matrix[course][i]) {
                    if (--indegree[i] == 0) {
                        queue.addLast(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
