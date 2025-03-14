import java.util.Scanner;

public class CodeTest5 {

    public static int solution(int n, int[] arr){
        int answer = 0, sum = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == n) answer++;
            while(sum >= n){
                sum -= arr[lt++];
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n-1; i++) {
            arr[i] = i+1;
        }
        System.out.println(solution(n,arr));
    }
}
