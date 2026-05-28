import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] chlid = new int[n];
        int[] dp = new int[n];
        int k = 0;
        // child에 아이들 저장
        for(int i = 0; i < n; i++) {
            chlid[i] = Integer.parseInt(br.readLine());
        }

        // dp 값 계산
        for(int i = 0; i < n; i++) {
            dp[i] = 1; // 자기자신
            for(int j = 0; j < i; j++) {
                if(chlid[i] > chlid[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            k = Math.max(k, dp[i]);
        }

        System.out.print(n-k);

    }

}