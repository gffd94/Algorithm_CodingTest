package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N+1]; // 합행렬
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[y]-prefixSum[x-1]).append("\n");
        }

        System.out.println(sb);
    }
}
