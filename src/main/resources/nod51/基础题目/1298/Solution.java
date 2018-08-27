import java.io.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        double[] x = new double[3];
        double[] y = new double[3];

        int n = Integer.parseInt(bufferedReader.readLine());
        while (0 < n--) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            double rx = Double.parseDouble(temp[0]);
            double ry = Double.parseDouble(temp[1]);
            double r = Double.parseDouble(temp[2]);
            for (int i=0; i<3; i++){
                String[] temp2 = bufferedReader.readLine().split("\\s+");
                x[i] = Double.parseDouble(temp2[0]);
                y[i] = Double.parseDouble(temp2[1]);
            }
            if (isIntersect(rx, ry, r, x, y)){
                bufferedWriter.write("Yes\n");
            } else {
                bufferedWriter.write("No\n");
            }
            bufferedWriter.flush();
        }
    }

    // 检查 圆 与 三角形 是否相交
    public static boolean isIntersect(double rx, double ry, double r, double[] x, double[] y){
        int countPoint = 0, countEdge = 0;
        for (int i=0; i<3; i++){
            if (countPointDis(rx, ry, x[i], y[i]) <= r){
                countPoint++;
            }
        }
        if (1 == countPoint || 2 == countPoint){
            // 三角形的1个或2个顶点在圆内部时，三角形和圆必相交
            return true;
        } else if(3 == countPoint){
            // 三角形的3个顶点都在圆内部时，三角形和圆没有相交
            return false;
        } else {
            for (int i=0; i<3; i++){
                if (countEdgeDis(rx, ry, x[i], y[i], x[(i+1)%3], y[(i+1)%3]) <= r){
                    countEdge++;
                }
            }
            if (0 == countEdge){
                return false;
            } else {
                return true;
            }
        }
    }

    // 计算两点之间的距离
    public static double countPointDis(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    /*
    计算点 P 到线段 AB 的距离
    1: P在直线AB的投影不在线段AB内部，此时返回AP 或者 BP
    2: P在直线AB的投影在线段AB内部，投影点为 C 此时返回 CP
     */
    public static double countEdgeDis(double xp, double yp, double xa, double ya, double xb, double yb) {
        double xAB = xb - xa;
        double yAB = yb - ya;
        double xAP = xp - xa;
        double yAP = yp - ya;

        double AP = countPointDis(xa, ya, xp, yp);
        double BP = countPointDis(xb, yb, xp, yp);
        double AB = countPointDis(xa, ya, xb, yb);

        double r = (xAB * xAP + yAB * yAP) / (AB * AB);
        if (1 <= r) {
            return BP;
        } else if (0 >= r) {
            return AP;
        } else {
            // 此时 P 在线段AB的投影点为C，可得 AC^2 + CP^2 = AP^2
            double AC = r * AB;
            double CP = Math.sqrt(AP * AP - AC * AC);
            return CP;
        }
    }
}
