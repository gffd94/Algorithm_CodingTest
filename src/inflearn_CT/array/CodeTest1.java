package inflearn_CT.array;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeTest1 {

    public ArrayList<Integer> solution (int n, int[] a, int m, int[] b){
        ArrayList<Integer> answer = new ArrayList<>();
            int p1 = 0, p2 = 0;
            while(p1<n && p2<m){
                if(a[p1] < b[p2]){
                    answer.add(a[p1++]);
                }else{
                    answer.add(b[p2++]);
                }
            }

            while(p1<n) answer.add(a[p1++]);
            while(p2<m) answer.add(b[p2++]);

        return answer;
    }

    public static void main(String[] args) {
        CodeTest1 ct = new CodeTest1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        ct.solution(n,a,m,b);

        for (int x : ct.solution(n,a,m,b)){
            System.out.print(x+" ");
        }

    }
}
