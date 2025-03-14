import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class CodeTest11 {

    public static int solution(int n, int k, int[] arr){
        int answer = -1;
        // 내림차순
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int l = j+1; l < n; l++) {
                    Tset.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        int count = 0;
        for (int x: Tset){
            count++;
            if(count == k) return x;
        }

        return  answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]  = sc.nextInt();
        }
        System.out.println(solution(n , k, arr));
    }
}
