package baekjoon_CT.greedy;

import java.util.*;
import java.io.*;

public class BOJ_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while(true){
            // 1. 홀수 처리
            for (int i = 0; i < N; i++) {
                if(B[i] % 2 != 0) { // 홀수라면
                    B[i]--;         // 1을 뺀다
                    count++;        // 총 연산 횟수 증가
                }
            }
            // 2. 종료 검사
            boolean isAllZero = true;
            for (int i = 0; i < N; i++) {
                if(B[i] > 0) {
                    isAllZero = false;
                    break;
                }
            }
            // 다 0이면 나누지 말고 여기서 끝.
            if(isAllZero) break;

            // 3. 짝수 처리
            // 위에서 홀수인 수는 정리했으므로 다 짝수만 남음
            for (int i = 0; i < N; i++){
                B[i] /= 2;
            }
            count++;
        }

        System.out.println(count);
    }
}
