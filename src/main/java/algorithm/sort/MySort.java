package algorithm.sort;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/30
 */
public class MySort {
    public static void main(String[] args) {
        int[] numbers = {99, 1, 22, 34, 89, 2, 1, 9, 11};

        printArray(numbers);

//        bubbleSort(numbers);
//        quickSort(numbers);
//        insertSort(numbers);
//        selectSort(numbers);
//        mergeSort(numbers);
        shellSort(numbers);

        printArray(numbers);

    }

    /**
     * 优化的冒泡排序
     * 稳定
     * <p>
     * 最坏: O(n^2)
     * 最好: O(n)
     * 平均: O(n^2)
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        boolean isOrdered = false;
        for (int i = nums.length - 1; !isOrdered && i >= 0; --i) {
            isOrdered = true;
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isOrdered = false;
                }
            }
        }
    }

    /**
     * 直接插入排序
     * 稳定
     * <p>
     * 最坏: O(n^2)
     * 最好: O(n)
     * 平均: O(n^2)
     *
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        for (int i = 1; i < nums.length; ++i) {
            for (int j = i - 1; j >= 0 && nums[j] > nums[j + 1]; --j) {
                swap(nums, j, j + 1);
            }
        }
    }

    /**
     * 选择排序
     * 不稳定
     * <p>
     * 最坏: O(n^2)
     * 最好: O(n^2)
     * 平均: O(n^2)
     *
     * @param nums
     */
    public static void selectSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    /**
     * 快速排序
     * 不稳定
     * <p>
     * 最坏: O(n^2)
     * 最好: O(n*log(n)) 或 O(n)
     * 平均: O(n*log(n))
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        quickSortCore(nums, 0, nums.length - 1);
    }

    public static void quickSortCore(int[] nums, int left, int right) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        int index;
        if (left < right) {
            index = partition(nums, left, right);
            quickSortCore(nums, left, index - 1);
            quickSortCore(nums, index + 1, right);
        }
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                --right;
            }
            nums[left] = nums[right];

            while (left < right && nums[left] <= pivot) {
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;

        return left;
    }

    /**
     * 归并排序
     * 稳定
     * <p>
     * 最坏: O(log(n))
     * 最好: O(log(n))
     * 平均: O(log(n))
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        mergeSortCore(nums, 0, nums.length - 1);
    }

    public static void mergeSortCore(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortCore(nums, left, mid);
            mergeSortCore(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        // 左指针
        int i = left;
        // 右指针
        int j = mid + 1;
        int k = 0;
        // 较小的数字先存入到数组中
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int n = 0; n < temp.length; ++n) {
            nums[left + n] = temp[n];
        }
    }

    /**
     * 希尔排序
     * 不稳定
     * <p>
     * 最坏: O(n^2)
     * 最好: O(n*log(n))
     * 平均: 取决于增量序列的函数
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        if (null == nums || 1 >= nums.length) {
            return;
        }

        for (int gap = nums.length / 2; gap > 0; --gap) {
            for (int i = gap; i < nums.length; i += gap) {
                for (int j = i - gap; j >= 0 && nums[j] > nums[j + gap]; j -= gap) {
                    swap(nums, j, j + gap);
                }
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(int[] array) {
        for (int t : array) {
            System.out.print(t);
            System.out.print(" ");
        }
        System.out.println();
    }
}
