import java.util.*;

public class Solution {

    public static int[][] initMatrix(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = value;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nodeNumber = sc.nextInt();
            int edgeNumber = sc.nextInt();
            int startID = sc.nextInt();
            int endID = sc.nextInt();

            int[][] matrix = new int[nodeNumber][nodeNumber];
            matrix = Solution.initMatrix(matrix, Integer.MAX_VALUE);

            boolean[] handled = new boolean[nodeNumber];    //标记节点是否已经被处理过
            int[] nodeScore = new int[nodeNumber];          //每个节点的分数
            int[] sumScore = new int[nodeNumber];           //开始节点到节点i可以获得的最大分数
            int[] shortestPath = new int[nodeNumber];       //开始节点到节点i的最短路径

            for (int i = 0; i < nodeNumber; i++) {
                shortestPath[i] = Integer.MAX_VALUE;
            }
            shortestPath[startID] = 0;

            for (int i = 0; i < nodeNumber; i++) {
                nodeScore[i] = sc.nextInt();
            }
            sumScore[startID] = nodeScore[startID];

            for (int i = 0; i < edgeNumber; i++) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                int value = sc.nextInt();
                matrix[r][c] = value;
                matrix[c][r] = value;
            }

            Queue<Edge> queue = new PriorityQueue<>();
            queue.add(new Edge(startID, 0));
            Edge currentNode = null;

            while (!queue.isEmpty()) {
                currentNode = queue.poll();
                if (handled[currentNode.getNodeID()]) {
                    continue;
                }

                shortestPath[currentNode.getNodeID()] = currentNode.getWeight();
                handled[currentNode.getNodeID()] = true;

                if (currentNode.getNodeID() == endID) {
                    break;
                }

                for (int i = 0; i < nodeNumber; i++) {
                    if (!handled[i] && (matrix[currentNode.getNodeID()][i] != Integer.MAX_VALUE)) {
                        /*
                        解题关键代码！！！
                        如果路径距离相同,选择可以得到的最大分值
                         */
                        if ((shortestPath[currentNode.getNodeID()] + matrix[currentNode.getNodeID()][i])
                                == shortestPath[i]) {       //最短路径值相同,无需改变shortestPath[i]的值.
                            sumScore[i] = Math.max(sumScore[currentNode.getNodeID()] + nodeScore[i],
                                    sumScore[i]);
                        } else if ((shortestPath[currentNode.getNodeID()] + matrix[currentNode.getNodeID()][i])
                                < shortestPath[i]) {
                            shortestPath[i] = shortestPath[currentNode.getNodeID()] + matrix[currentNode.getNodeID()][i];
                            sumScore[i] = sumScore[currentNode.getNodeID()] + nodeScore[i];
                        }

                        queue.add(new Edge(i, shortestPath[i]));
                    }
                }
            }
            System.out.println(shortestPath[endID] + " " + sumScore[endID]);
        }
    }
}

class Edge implements Comparable<Edge> {
    private Integer weight;
    private Integer nodeID;

    public Edge(int id, int w) {
        this.weight = w;
        this.nodeID = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getNodeID() {
        return nodeID;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight.compareTo(e.getWeight());
    }
}