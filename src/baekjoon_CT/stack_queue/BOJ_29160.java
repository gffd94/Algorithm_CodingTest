package baekjoon_CT.stack_queue;
import java.util.*;
import java.io.*;

public class BOJ_29160 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Map<Integer, PriorityQueue<Integer>> teamMap = new HashMap<>();

        // 1~11 번까지 포지션 초기화
        for(int i = 1; i <= N; i++){
            teamMap.put(i, new PriorityQueue<>(Collections.reverseOrder()));
        }

        // 입력받기 포지션인 key 값에 value를 PriorityQueue에 넣기
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            teamMap.get(pos).add(value);
        }

        // K년 시뮬레이션
        for(int year = 1; year <= K; year++){
            for(int pos = 1; pos <= N; pos++){
                PriorityQueue<Integer> pq = teamMap.get(pos);

                // 포지션 선수가 있는 경우
                if(!pq.isEmpty()){
                    int topPlayer = pq.poll(); // 1) 1등 꺼내기

                    if(topPlayer > 0){
                        topPlayer--; // 2) 전체 가지 감소
                        pq.offer(topPlayer); // 3) 다시 넣기
                    }else {
                        pq.offer(0); // 포지션 선수 없으면 공석
                    }
                }

            }
        }

        // 합계
        long total = 0;
        for(int pos = 1; pos <= 11; pos++){
            PriorityQueue<Integer> pq = teamMap.get(pos);
            total += pq.peek();
        }

        System.out.println(total);
    }

}
