import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args) {

//        functionOne();
//        functionTwo();
        functionThree();

    }

    /**
     * 采用最长公共子序列方法求解
     * 数组一： 按照输入顺序保存
     * 数组二： 按照从大到小顺序保存
     * 求出 数组一 与 数组二 的最长公共子序列即为 最长单增子序列的长度
     */
    public static void functionOne() {

        Scanner sc = new Scanner(System.in);
        int stringLength = sc.nextInt();
        int[] first = new int[stringLength];
        int[] second = new int[stringLength];
        for (int i = 0; i < stringLength; i++) {
            first[i] = sc.nextInt();
            second[i] = first[i];
        }

        Arrays.sort(second);

        int[][] dp = new int[first.length + 1][second.length + 1];
        int[][] flag = new int[first.length + 1][second.length + 1];

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    // 行 列都回溯
                    flag[i + 1][j + 1] = 1;
                } else if (dp[i][j + 1] >= dp[i + 1][j]) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                    // 行 回溯
                    flag[i + 1][j + 1] = 2;
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                    //列 回溯
                    flag[i + 1][j + 1] = 3;
                }
            }
        }

        int maxCommonLength = dp[first.length][second.length];
        int i = first.length, j = second.length, answerCount = 0;
        int[] answer = new int[maxCommonLength];
        for (; i > 0 && j > 0; ) {
            // 只有标志位为1 相应位置上的字符才为公共字符
            if (1 == flag[i][j]) {
                answer[maxCommonLength - 1] = first[i - 1];
                answerCount++;
                maxCommonLength--;
                i--;
                j--;
            } else if (2 == flag[i][j]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(answerCount);
    }

    /**
     * O(n^2)算法
     * 当我们定义问题F(i)为以a[i]结束的最长不下降子序列时（这个子序列的最后一项是a[i]），则问题F(i)有i个子问题：F(0), F(1), …, F(i-1)。
     * <p>
     * 我们要使F(i)最长，则要在满足0 <= j < i和a[j] < a[i]条件的j中，找到使得F(j)最大的j，此时这时F(i)=F(j)+1。
     * <p>
     * 如果不存在满足0 <= j < i和a[j] < a[i]条件的j，则
     * a[i]不存在前驱节点,那么F(i)=1。
     * <p>
     * 最后从F(0)~F(a.length-1)，找出最大值就是最长不下降子序列长度。
     */
    public static void functionTwo() {
        Scanner sc = new Scanner(System.in);

        int stringLength = sc.nextInt();
        int[] a = new int[stringLength];

        for (int i = 0; i < stringLength; i++) {
            a[i] = sc.nextInt();
        }

        int[] len = new int[stringLength];
        // 每次循环就确定了前i项中的最长不下降子序列的长度并存放在len[i]中
        for (int i = 0; i < a.length; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < len.length; i++) {
            if (len[i] > max) {
                max = len[i];
            }
        }
        System.out.println(max);
    }

    /**
     * 定义：a[1..n]为原始序列，d[k]表示长度为k的不下降子序列末尾元素的最小值，len表示当前已知的最长子序列的长度。
     * <p>
     * 初始化：d[1]=a[1]; len=1;（0个元素的时候特判一下）
     * <p>
     * 现在我们已知最长的不下降子序列长度为1，末尾元素的最小值为a[1]，那么我们让i从2到n循环，依次求出前i个元素的最长不下降子序列的长度，
     * 循环的时候我们只需要维护好d这个数组还有len就可以了。关键问题就是怎么维护？
     * <p>
     * 可以看出我们是要用logn的复杂度维护的。实际上利用了d数组的一个性质：单调不减性。（长度更长了，d[k]的值是不会减小的）
     * <p>
     * 考虑新进来一个元素a[i]：
     * <p>
     * 如果这个元素大于等于d[len]，直接让d[len+1]=a[i]，然后len++。这个很好理解，当前最长的长度变成了len+1，而且d数组也添加了一个元素。
     * <p>
     * 如果这个元素小于d[len]呢？说明它不能接在最后一个后面了。那我们就看一下它该接在谁后面。
     * <p>
     * 准确的说，并不是接在谁后面。而是替换掉谁。因为它接在前面的谁后面都是没有意义的，再接也超不过最长的len，所以是替换掉别人。
     * <p>
     * 那么替换掉谁呢？就是替换掉那个最该被它替换的那个。也就是在d数组中第一个大于它的。第一个意味着前面的都小于等于它。
     * <p>
     * 假设第一个大于它的是d[j]，说明d[1..j-1]都小于等于它，那么它完全可以接上d[j-1]然后生成一个长度为j的不下降子序列，
     * 而且这个子序列比当前的d[j]这个子序列更有潜力（因为这个数比d[j]小）。所以就替换掉它就行了，也就是d[j]=a[i]。
     * <p>
     * 其实这个位置也是它唯一能够替换的位置（前面的替了不满足d[k]最小值的定义，后面替换了不满足不下降序列）
     * <p>
     * 至于第一个大于它的怎么找……STL upper_bound。每次复杂度logn。
     * <p>
     * 至此，我们就神奇的解决了这个问题。
     */
    public static void functionThree() {
        Scanner sc = new Scanner(System.in);

        int stringLength = sc.nextInt();

        // 0个元素特判一下
        if (0 == stringLength) {
            System.out.println("0");
            return;
        }

        int[] a = new int[stringLength];

        for (int i = 0; i < stringLength; i++) {
            a[i] = sc.nextInt();
        }

        int[] d = new int[stringLength + 1];
        // 初始化
        d[1] = a[0];
        int len = 1;
        for (int i = 1; i < a.length; i++) {
            // 如果可以接在len后面 就接上
            if (a[i] >= d[len]) {
                d[++len] = a[i];
            } else {
                /**
                 *  否则就找一个最该替换的替换掉
                 *  d[len]>a[i],可以确保d[1]~d[len]中存在大于等于a[i]的元素
                 *  找到第一个大于它的d的下标
                 */
                int j = binarySearch(d, a[i], 1, len);
                d[j] = a[i];
            }
        }

        System.out.println(len);
    }

    private static int binarySearch(int[] d, int a, int left, int right) {//定义二分查找函数
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (d[mid] == a) {
                left = mid;
                return left;
            } else if (d[mid] > a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
