package baekjoon_CT.backTracking;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
    static int N, M;
    static int[] result;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visited = new boolean[N+1];

        backTracking(0);
    }

    private static void backTracking(int depth) {
        if(depth == M){
            for (int i : result) {
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[depth] = i;
                backTracking(depth+1);
                visited[i] = false;
            }
        }

    }
}
