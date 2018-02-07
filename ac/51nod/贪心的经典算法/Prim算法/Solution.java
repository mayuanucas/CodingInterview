import java.util.Scanner;

public class Solution {

    public static int[][] initMatrix(int[][] matrix, int defaultValue){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                matrix[i][j] = defaultValue;
            }
        }
        return matrix;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int nodeNumber = scanner.nextInt();     //节点数量
            int edgeNumber = scanner.nextInt();     //边的数量
            int[][] matrix = new int[nodeNumber+1][nodeNumber+1];   //该图的邻接矩阵表示
            int[] distanceToU = new int[nodeNumber+1];      //记录节点i到顶点集U的最短距离（即U中所有点到i的距离之最小者）
            boolean[] visit = new boolean[nodeNumber+1];    //记录节点i是否被访问,即是否加入了定点集U中
            int answer = 0;                         //最小生成树的所有边的权值之和

            matrix = Solution.initMatrix(matrix, Integer.MAX_VALUE);    //需要对矩阵初始化 两节点不相连 则为Integer.MAX_VALUE

            int r, c, value;                        //行 列 值
            while (edgeNumber > 0){
                r = scanner.nextInt();
                c = scanner.nextInt();
                value = scanner.nextInt();
                matrix[r][c] = matrix[c][r] = value;
                edgeNumber--;
            }

            for(int i=1; i<=nodeNumber; i++){       //从1号节点开始
                distanceToU[i] = matrix[1][i];
            }
            distanceToU[1] = 0;                     //1号节点已经在U中 所以到U的距离为0
            visit[1] = true;                        //标记1号节点已经在U中

            int minEdge, nodeAddToU=0;
            for(int i=1; i<nodeNumber; i++){        //由于1号节点已经访问过, 所以只需要再访问n-1个
                minEdge = Integer.MAX_VALUE;
                for(int j=1; j<=nodeNumber; j++){   //在所有u∈U,v∈ V－U 的边(u,v)∈E中,找一条权最小的边(u,v)
                    if(!visit[j] && distanceToU[j] < minEdge){  //这里找的是：与顶点集U相邻的距离最小值
                        minEdge = distanceToU[j];
                        nodeAddToU = j;
                    }
                }
                visit[nodeAddToU] = true;           //找到节点 添加到U中
                answer += minEdge;

                for(int j=1; j<=nodeNumber; j++){
                    if(!visit[j] && matrix[nodeAddToU][j] < distanceToU[j]){
                        distanceToU[j] = matrix[nodeAddToU][j];
                    }

                }
            }

            System.out.println(answer);
        }
    }
}
