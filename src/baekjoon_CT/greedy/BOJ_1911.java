package baekjoon_CT.greedy;

import java.util.*;
import java.io.*;

public class BOJ_1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 1. 웅덩이 정보를 저장
        int[][] pools = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pools[i][0] = Integer.parseInt(st.nextToken()); // 시작위치
            pools[i][1] = Integer.parseInt(st.nextToken()); // 끝 위치
        }

        // 2. 웅덩이의 시작 위치를 기준으로 오룸차순 정렬 (이어 붙여야 하니까)
        Arrays.sort(pools, (a, b) -> a[0] - b[0]);

        int count = 0; // 널빤지 갯수
        int range = 0; // 현재 널빤지가 덮고 있는 마지막 위치

        // 3. 웅덩이를 순회하며 널빤지 덮기
        for(int i = 0; i < N; i++){
            int start = pools[i][0];
            int end = pools[i][1];

            // 널빤지가 웅덩이 시작점 보다 뒤쳐져 있다면 당겨오기
            if(start > range){
                range = start;
            }

            // 널빤지가 웅덩이 끝점 까지 다 못 덮었다면
            if(end > range) {
                int remain = end - range; // 남아있는 웅덩이 길이

                int cnt = (remain + L - 1)/ L; // 깔끔하게 올림처리
                count += cnt; // 널빤지 누적
                range += L * cnt; // 덮은 위치를 연장

            }
        }

        System.out.println(count);
    }
}
