package baekjoon_CT.array;

import java.util.*;
import java.io.*;

public class BOJ_1564 {

    static int W, H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int N = Integer.parseInt(br.readLine());
        List<Integer> shop = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int dirt = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());
            // 0,0을 기준으로 거리 잰 값 넣기
            shop.add(absDistance(dirt, loc));
        }
        // 동근이 위치
        st = new StringTokenizer(br.readLine());
        int dgDir = Integer.parseInt(st.nextToken());
        int dgLoc = Integer.parseInt(st.nextToken());

        int dgLocation = absDistance(dgDir, dgLoc);
        int totalDistance = (H + W) * 2;
        int answer = 0;

        for(int dist : shop){
            // 1. 시계방향거리
                int dist1 = Math.abs(dgLocation - dist);
            // 2. 반시계방향거리
                int dist2 = totalDistance - dist1;

                answer += Math.min(dist1, dist2);
        }

        System.out.println(answer);

    }

    // 0,0을 기준으로 절대 거리 구하기
    private static int absDistance(int dirt, int loc){
        switch (dirt){
            case 1: // 북쪽
                return loc;
            case 2: // 남쪽
                return W + H + (W - loc);
            case 3: // 서쪽
                return W + H + W + (H - loc);
            case 4: // 동쪽
                return W + loc;

        }
        return 0;

    }




}
