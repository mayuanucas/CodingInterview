import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1995 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            switch (x) {
                case 1:
                    switch (y) {
                        case 1:
                            bufferedWriter.write("Win\n6\n");
                            bufferedWriter.flush();
                            break;
                        case 2:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 3:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 4:
                            bufferedWriter.write("Win\n6\n");
                            bufferedWriter.flush();
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    switch (y) {
                        case 1:
                            bufferedWriter.write("Equal\n0\n");
                            bufferedWriter.flush();
                            break;
                        case 2:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 3:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 4:
                            bufferedWriter.write("Equal\n0\n");
                            bufferedWriter.flush();
                            break;
                        default:
                            break;
                    }
                    break;
                case 3:
                    switch (y) {
                        case 1:
                            bufferedWriter.write("Win\n6\n");
                            bufferedWriter.flush();
                            break;
                        case 2:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 3:
                            bufferedWriter.write("Win\n4\n");
                            bufferedWriter.flush();
                            break;
                        case 4:
                            bufferedWriter.write("Win\n6\n");
                            bufferedWriter.flush();
                            break;
                        default:
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
    }
}