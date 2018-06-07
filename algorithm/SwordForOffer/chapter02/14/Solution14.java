/**
 * @author mayuan
 * @desc
 * @date 2018/02/28
 */
public class Solution14 {

    public static void main(String[] args) {
        System.out.println(maxProductAfterCutting(8));
        System.out.println(maxProductAfterCutting2(8));
    }

    public static int maxProductAfterCutting(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        /*
        product 代表 一段绳子 剪 或 不剪 后，乘积的最大值
         */
        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[length];
    }

    public static int maxProductAfterCutting2(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

        int timesOf3 = length / 3;
        if (length - timesOf3 * 3 == 1) {
            timesOf3--;
        }

        int timesOf2 = (length - timesOf3 * 3) / 2;
        return (int) (Math.pow(2, timesOf2) * Math.pow(3, timesOf3));
    }

}
