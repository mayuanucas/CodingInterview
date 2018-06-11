import java.util.Arrays;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/11
 */
public class SelectSort {

    public static void main(String[] args) {
        int testTime = 10000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            selectSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice Answer!" : "Wrong Answer!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectSort(arr);
        printArray(arr);
    }

    /**
     * 选择排序 O(n^2)
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = (arr[j] < arr[minIndex]) ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    /**
     * 不使用临时变量，直接交换两个整型数据。
     */
    public static void swap(int[] arr, int i, int j) {
        // 当自己与自己交换时，数组该位置将产生0
//        arr[i] ^= arr[j];
//        arr[j] ^= arr[i];
//        arr[i] ^= arr[j];

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
