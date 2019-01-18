package algorithm.leetcode;

import java.util.Random;

/**
 * @author: mayuan
 * @desc: 摆动排序 II
 * @date: 2019/01/14
 */
public class Solution324 {

    public static void main(String[] args) {
        int[] array = {1, 5, 1, 1, 6, 4};

        new Solution324().wiggleSort(array);

        for (int e : array) {
            System.out.print(e + " ");
        }
    }

    public void wiggleSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        // 找到数组的中位数,该数字可以把全部数据分为两组:
        // A组数值都小于该中位数,B组数值都大于等于该中位数
        // findKthLargest调用之后,左侧数字均小于轴,右侧数字均大于轴
        int media = findKthLargest(nums, (nums.length + 1) / 2);
        // 借鉴荷兰国旗问题(3类数字排序)
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            // 奇数索引位置的值需要大于中位数,如果发现该位置数字值大于中位数,赶紧把该数字移动到前面
            if (nums[A(j, nums.length)] > media) {
                swap(nums, A(i, nums.length), A(j, nums.length));
                ++i;
                ++j;
            } else if (nums[A(j, nums.length)] < media) {
                swap(nums, A(j, nums.length), A(k, nums.length));
                --k;
            } else {
                ++j;
            }
        }
    }

    /**
     * 索引映射变换,借鉴轴划分的思想.
     * 轴之前位置的数字值均大于轴,轴之后位置的数字均小于轴
     *
     * @param i
     * @param n
     * @return
     */
    public int A(int i, int n) {
        int index = (1 + 2 * i) % (n | 1);
        return index;
    }

    /**
     * 找到数组中第K个大的数字
     *
     * @param array
     * @param k
     * @return
     */
    public int findKthLargest(int[] array, int k) {
        // 数组是从小到大排列,第K个大的数字,其下标索引即为
        // 从左往右索引为 array.length - k 的数字
        k = array.length - k;
        int l = 0, r = array.length - 1;
        while (l < r) {
            int index = partition(array, l, r);
            if (k == index) {
                break;
            } else if (k > index) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return array[k];
    }

    public int partition(int[] array, int left, int right) {
        int random = new Random().nextInt(right - left + 1) + left;
        swap(array, left, random);

        int pivot = array[left];
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                --right;
            }
            array[left] = array[right];
            while (left < right && array[left] <= pivot) {
                ++left;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
