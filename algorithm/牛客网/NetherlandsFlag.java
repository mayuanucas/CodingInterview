import java.util.Arrays;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/19
 */
public class NetherlandsFlag {

    public static int[] partition(int[] arr, int L, int R, int num) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < num) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > num) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 绝对正确的方法
     *
     * @param arr
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    /**
     * 随机数组发生器
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 从原数组复制出一个副本数组
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (null == arr) {
            return null;
        }

        int[] newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    /**
     * 判断两个数组是否相同
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if (null == arr1 && null == arr2) {
            return true;
        }
        if ((null == arr1 && null != arr2) || (null != arr1 && null == arr2)) {
            return false;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        if (null == arr) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
