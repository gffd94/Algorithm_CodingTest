package baekjoon_CT.greedy;

import java.util.*;
import java.io.*;

public class BOJ_1826 {

    // 주유소 정보를 담을 클래스 ( 거리 수 정렬을 위해 Comparable 구현
    static class GasStation implements Comparable<GasStation>{
        int dist;
        int fuel;

        public GasStation(int dist, int fuel) {
            this.dist = dist;
            this.fuel = fuel;
        }

        @Override
        public int compareTo(GasStation o) {
            return this.dist - o.dist; // 거리 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 주유소 개수

        // 1. 주유소 리스트 (거리순)
        ArrayList<GasStation> stations = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stations.add(new GasStation(a,b));
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 2. 거리 순으로 정렬 ( 가까운 주유소 부터 마주침 )
        Collections.sort(stations);

        // 3. 지나온 주유소 중 연료가 많은 순으로 저장할 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int ans = 0; // 주유 횟수
        int idx = 0; // 현재 살펴보고 있는 주유소 인덱스

        // P : 내가 갈 수 있는 최대 거리를 의미
        while (P < L) {
            // 내 연료로 갈 수 있는 모든 주유소를 스캔해서 큐에 넣음
            while (idx < N && stations.get(idx).dist <= P) pq.add(stations.get(idx++).fuel);

            // 더 이상 갈 곳이 없는데 목적지에 도착하지 못하면 -1
            if(pq.isEmpty()){
                System.out.println(-1);
                return;
            }

            // 가장 연료를 많이 주는 곳에서 주유
            ans++;
            P += pq.poll(); // 연료 충전 ( 이동 거리 증가 )
        }

        System.out.println(ans);
    }
}
