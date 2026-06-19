
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[sl1+1][sl2+1];
        int sl1 = s1.length();
        int sl2 = s2.length();
        for(int i = 1; i <= sl1; i++) {
            for(int j = 1; j <= sl2; j++) {
                }
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    }
                // 둘이 문자가 같다면
                    // 글자가 같으면? 대각선 위 칸 점수(dp[i-1][j-1])에다가 내가 번 1점을 더해서 현재 칸에 저장!
                } else {
                    // 글자가 다르면? 내 위 칸과 내 왼쪽 칸 중 더 큰 점수를 현재 칸에 그대로 복사!
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i - 1][j - 1] + 1;
    }
       


        }
         System.out.print(dp[sl1][sl2]);
import java.io.*;
import java.util.*;
}