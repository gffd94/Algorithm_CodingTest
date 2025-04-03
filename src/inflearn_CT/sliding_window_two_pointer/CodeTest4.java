package inflearn_CT.sliding_window_two_pointer;

import java.util.Scanner;

public class CodeTest4 {

    public static int solution (int n , int m, int[] arr){
        int answer = 0 , sum = 0 , lt = 0;

        for (int rt = lt; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m){
                answer++;
            }
            while(sum >= m){
                // lt 값을 변경했을때도 sum 이 m 이랑 같은지 확인
                sum -= arr[lt++];
                if(sum == m){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solution(n , m , arr));
    }
}
