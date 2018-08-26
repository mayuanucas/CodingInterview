import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        while (0 < n--){
            String[] temp = bufferedReader.readLine().split("\\s+");
            if (Solution.paichi(
                    Double.parseDouble(temp[0]),
                    Double.parseDouble(temp[1]),
                    Double.parseDouble(temp[2]),
                    Double.parseDouble(temp[3]),
                    Double.parseDouble(temp[4]),
                    Double.parseDouble(temp[5]),
                    Double.parseDouble(temp[6]),
                    Double.parseDouble(temp[7]))){
                bufferedWriter.write("Yes\n");
            } else {
                bufferedWriter.write("No\n");
            }
            bufferedWriter.flush();
        }
    }

    /*
    点的坐标
    a: (x1, y1)
    b: (x2, y2)
    c: (x3, y3)
    d: (x4, y4)

    判读 线段ab 与 线段 cd 不想交，即判断 ba 是否 夹在 bc 与 bd 中间，
    同时还需要判断 dc 是否夹在 da 与 db 中间，这里使用叉积判断。

     */
    public static boolean paichi(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        double[] p = new double[4];
        // ba × bc
        p[0] = (x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2);
        // ba × bd
        p[1] = (x1 - x2) * (y4 - y2) - (y1 - y2) * (x4 - x2);
        // dc × da
        p[2] = (x3 - x4) * (y1 - y4) - (y3 - y4) * (x1 - x4);
        // dc × db
        p[3] = (x3 - x4) * (y2 - y4) - (y3 - y4) * (x2 - x4);

        if ((0 >= p[0] * p[1]) && (0 >= p[2] * p[3])) {
            return true;
        }
        return false;
    }

}
