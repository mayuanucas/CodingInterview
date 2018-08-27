import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {

    public static int maxn = 1000100;
    public static int index = 0;
    public static int[] mark = new int[maxn];
    public static int[] prime = new int[maxn];

    public static void printTable(){
        for (int i=2; i<maxn; i++){
            if (mark[i] == 0){
                prime[index++] = i;
                if (i<=Math.sqrt(maxn)){
                    for (int j=i*i; j<maxn; j+=i){
                        mark[j] = 1;
                    }
                }
            }
        }
    }

    public static int getPrime(int n){
        int pos, i=0;
        while (prime[i]<n){
            i++;
        }
        pos = i+1;
        i=0;
        while (prime[i]<pos){
            i++;
        }
        return prime[prime[i]-1];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printTable();
        System.out.println(getPrime(n));
    }
}
