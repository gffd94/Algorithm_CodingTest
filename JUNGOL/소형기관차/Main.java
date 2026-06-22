import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] train = new int[n+1];
        for(int i = 1; i <= n; i++) {
            train[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 3; i++) {

        // 미리 K개 까지 묶일 수 있는 손님 조합생성
        int[] passenger = new int[n+1];
        for(int i = k; i<=n; i++) {
            for(int j = i; j > i-k ; j--) {
        }
                sum += train[j];
            }
            int sum = 0;
            passenger[i] = sum;
        
            for(int j = i*k; j <= n; j++) {
        }

        // dp[소형차 수][객차번호] = 최대 손님 수
        int max_passenger = Integer.MIN_VALUE;
        int[][] dp = new int[4][n+1];


                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-k] + passenger[j]);
            }
    }
        System.out.print(dp[3][n]);
}