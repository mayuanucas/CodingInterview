import java.util.Scanner;

public class Solution {

    private static int[] tempArr;
    private static int answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int totalNumber = sc.nextInt();

        int[] arrNumber = new int[totalNumber];
        tempArr = new int[totalNumber];

        for(int i=0; i<totalNumber; i++){
            arrNumber[i] = sc.nextInt();
        }

        Solution.mergeSort(arrNumber, 0, totalNumber - 1);

        System.out.println(answer);
        
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int current = 0;
        while (i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                tempArr[current++] = arr[i++];
            }else{
                tempArr[current++] = arr[j++];
                answer += (mid - i + 1);
            }
        }

        while (i <= mid){
            tempArr[current++] = arr[i++];
        }
        while (j <= high){
            tempArr[current++] = arr[j++];
        }

        for(int k=0; k<current; k++){
            arr[low++] = tempArr[k];
        }
    }
}
