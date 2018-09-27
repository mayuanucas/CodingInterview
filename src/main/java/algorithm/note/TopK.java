package algorithm.note;

/**
 * @author: mayuan
 * @desc: 从n个数中，找出最大的k个数，这就是经典的TopK问题.
 * (1.排序是最容易想到的方法，将n个数排序之后，取出最大的k个，即为所得。 O(n*lg(n)))
 * (2.采用冒泡排序,每冒一个泡，找出最大值，冒k个泡，就得到TopK。 O(n*k))
 * @date: 2018/09/24
 */
public class TopK {
    public static void main(String[] args) {
        int[] array = {9, 3, 1, 10, 5, 7, 6, 2, 8, 0, 4};
        final int k = 4;
        getTopK(array, k);
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n*********************");

        int[] ans = getTopK2(array.clone(), k);
        for (int n : ans) {
            System.out.print(n + " ");
        }
        System.out.println("\n*********************");
    }

    /**
     * 基于快速排序的思想(从大到小排序,前k个数即为所求)
     * 时间复杂度: O(n)
     * <p>
     * 我们知道，分治函数会返回一个position，在position左边的数都比第position个数大，在position右边的数都比第position小。
     * 我们不妨不断调用分治函数，直到它输出的position = K-1，此时position前面的K个数（0到K-1）就是要找的前K个数。
     *
     * @param array
     * @param k
     */
    public static void getTopK(int[] array, int k) {
        if (null == array || 0 >= array.length) {
            return;
        }

        int left = 0;
        int right = array.length - 1;
        int index = partition(array, left, right);
        // 不断调整轴的位置,直到 index = k-1
        while (index != k - 1) {
            if (index < k - 1) {
                left = index + 1;
                index = partition(array, left, right);
            }

            if (index > k - 1) {
                right = index - 1;
                index = partition(array, left, right);
            }
        }
    }

    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];

        while (left < right) {
            while (left < right && array[right] <= pivot) {
                --right;
            }
            array[left] = array[right];

            while (left < right && array[left] >= pivot) {
                ++left;
            }
            array[right] = array[left];
        }
        array[left] = pivot;
        return left;
    }

    /**
     * 基于堆排序的思想(构建一个小顶堆)
     * 时间复杂度: n*log(K)
     * 先用前k个元素生成一个小顶堆，这个小顶堆用于存储，当前最大的k个元素。
     * 接着，从第k+1个元素开始扫描，和堆顶（堆中最小的元素）比较，如果被扫描的元素大于堆顶，
     * 则替换堆顶的元素，并调整堆，以保证堆内的k个元素，总是当前已经扫描到数据中较大的k个元素。
     * 扫描完所有n-k个元素，最终堆中的k个元素，就是要求的TopK。
     * <p>
     * 好处:
     * 1:不会占用太多的内存空间（事实上，一次只读入一个数，内存只要求能容纳前K个数即可）
     * 2:由于（1），决定了它特别适合处理海量数据
     *
     * @param array
     * @param k
     * @return
     */
    public static int[] getTopK2(int[] array, int k) {
        int[] top = new int[k];
        for (int i = 0; i < k; ++i) {
            top[i] = array[i];
        }
        // 构建小顶堆
        for (int i = (top.length - 1) / 2; i >= 0; --i) {
            minHeapDown(top, i, top.length - 1);
        }


        //构建小顶堆后,依次比较剩余元素与堆顶元素的大小,比堆顶大的,说明它应该在堆中出现，则用它来替换掉堆顶元素，然后沉降。
        for (int i = k; i < array.length; ++i) {
            if (top[0] <= array[i]) {
                setHeapTop(top, array[i]);
            }
        }

        return top;
    }

    public static void setHeapTop(int[] array, int top) {
        array[0] = top;
        // 遍历之后,得到的数组是一个(最小)二叉堆
        for (int i = (array.length - 1) / 2; i >= 0; --i) {
            minHeapDown(array, i, array.length - 1);
        }
    }

    public static void minHeapDown(int[] array, int start, int end) {
        int current = start;
        //左子节点
        int left = current * 2 + 1;
        for (; left <= end; current = left, left = left * 2 + 1) {
            // left指向左右子节点中的最小节点
            if (left < end && array[left] > array[left + 1]) {
                ++left;
            }
            // 当前的堆已经是小顶堆,无需进行调整
            if (array[current] <= array[left]) {
                break;
            } else {
                swap(array, current, left);
            }
        }
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
