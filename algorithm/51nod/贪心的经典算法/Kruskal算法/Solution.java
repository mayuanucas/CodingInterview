import java.util.*;

public class Solution {

    /*
    构造树,更新根节点. 一条边的两个节点,分别进行查找根节点. 如果他们的根节点相同,表示添加这条边会构成环.
     */
    public static boolean checkCycle(Edge e, int[] path) {
        int aNode = e.getaNode();
        int bNode = e.getbNode();

        while (0 < path[aNode]) {
            aNode = path[aNode];
        }
        while (0 < path[bNode]) {
            bNode = path[bNode];
        }

        if (aNode != bNode) {
            path[aNode] = bNode;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nodeNumber = sc.nextInt();
            int edgeNumber = sc.nextInt();
            int[] path = new int[nodeNumber + 1];       //节点编号从1开始 所以此处数组长度应 +1
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < edgeNumber; i++) {
                edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
            Collections.sort(edges);

            int edgeChoose = 0, edgeVisit = 0, minCost = 0;             //已经选择边的数量 游览过边的数量 最小代价
            //最小生成树
            while ((edgeChoose != nodeNumber - 1) && (edgeVisit != edgeNumber)) {
                if (Solution.checkCycle(edges.get(edgeVisit), path)) {
                    minCost += edges.get(edgeVisit).getWeight();
                    edgeChoose++;
                }
                edgeVisit++;
            }
            System.out.println(minCost);
        }
    }
}

class Edge implements Comparable<Edge> {
    private Integer aNode;
    private Integer bNode;
    private Integer weight;

    public Edge(int a, int b, int w) {
        this.aNode = a;
        this.bNode = b;
        this.weight = w;
    }

    public Integer getaNode() {
        return aNode;
    }

    public Integer getbNode() {
        return bNode;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge e) {
        return this.weight.compareTo(e.getWeight());
    }
}