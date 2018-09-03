package review;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/02
 */
public class MySort0903 {
    public static void main(String[] args) {
        int[] numbers = {99, 1, 2, 18, 0, 3, 4, 8, 8};
        printArray(numbers);

//        heapSort(numbers);
//        quickSort(numbers);
//        selectSort(numbers);
//        bubbleSort(numbers);
//        mergeSort(numbers);
//        insertSort(numbers);
        shellSort(numbers);
        printArray(numbers);
    }

    public static void bubbleSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        boolean isSorted = false;
        for (int i = array.length - 1; i > 0 && !isSorted; --i) {
            isSorted = true;
            for (int j = 0; j < i; ++j) {
                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void shellSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        for (int gap = array.length / 2; gap > 0; --gap) {
            for (int i = gap; i < array.length; i += gap) {
                for (int j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {
                    swap(array, j, j + gap);
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        for (int i = 1; i < array.length; ++i) {
            for (int j = i - 1; j >= 0 && array[j] > array[j + 1]; --j) {
                swap(array, j, j + 1);
            }
        }
    }

    public static void mergeSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (null == array || 1 >= array.length) {
            return;
        }

        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;
        int i = left;
        int j = middle + 1;
        while (i <= middle && j <= right) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        for (int n = 0; n < temp.length; ++n) {
            array[left + n] = temp[n];
        }
    }

    public static void selectSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        for (int i = 0; i < array.length; ++i) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; ++j) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
    }

    public static void quickSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (null == array || 1 >= array.length) {
            return;
        }

        if (left < right) {
            int index = partiation(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }

    public static int partiation(int[] array, int left, int right) {
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

    public static void heapSort(int[] array) {
        if (null == array || 1 >= array.length) {
            return;
        }

        for (int i = (array.length - 1) / 2; i >= 0; --i) {
            maxHeapDown(array, i, array.length - 1);
        }

        for (int i = array.length - 1; i > 0; --i) {
            swap(array, 0, i);
            maxHeapDown(array, 0, i - 1);
        }
    }

    private static void maxHeapDown(int[] array, int start, int end) {
        int current = start;
        int left = start * 2 + 1;

        for (; left <= end; current = left, left = left * 2 + 1) {
            if (left < end && array[left] < array[left + 1]) {
                ++left;
            }
            if (array[current] >= array[left]) {
                return;
            } else {
                swap(array, current, left);
            }
        }
    }

    public static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void printArray(int[] array) {
        for (int t : array) {
            System.out.print(t);
            System.out.print(" ");
        }
        System.out.println();
    }
}
