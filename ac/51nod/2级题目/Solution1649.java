import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1649 {

    public static final int INF = 0x3f3f3f3f;

    public static void initInteger(int[] arr, int number) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = number;
        }
    }

    public static void initBoolean(boolean[] arr, boolean flag) {
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = flag;
        }
    }

    public static void init(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                matrix[i][j] = INF;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        boolean[] vis = new boolean[n + 1];
        int[] dis = new int[n + 1];
        int[][] train = new int[n + 1][n + 1];
        int[][] bus = new int[n + 1][n + 1];

        initInteger(dis, INF);
        init(train);
        init(bus);

        int u, v;
        String[] tmp;
        for (int i = 0; i < m; ++i) {
            tmp = bufferedReader.readLine().split("\\s+");
            u = Integer.parseInt(tmp[0]);
            v = Integer.parseInt(tmp[1]);
            train[u][v] = train[v][u] = 1;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (INF == train[i][j]) {
                    bus[i][j] = bus[j][i] = 1;
                }
            }
        }

        dijkstra(train, dis, vis, n);
        int ans1 = dis[n];

        dijkstra(bus, dis, vis, n);
        int ans2 = dis[n];

        int ans = (ans1 > ans2) ? ans1 : ans2;
        ans = (ans == INF) ? -1 : ans;

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }

    public static void dijkstra(int[][] map, int[] dis, boolean[] vis, int n) {
        initInteger(dis, INF);
        initBoolean(vis, false);
        dis[1] = 0;

        for (int i = 1; i <= n; ++i) {
            int tmp = INF, k = -1;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && dis[j] < tmp) {
                    tmp = dis[j];
                    k = j;
                }
            }

            if (INF == tmp) {
                break;
            }

            vis[k] = true;
            for (int j = 1; j <= n; ++j) {
                if (!vis[j] && (dis[k] + map[k][j]) < dis[j]) {
                    dis[j] = dis[k] + map[k][j];
                }
            }
        }
    }
}
