package programmers_CT.test4;

import java.util.*;

public class ProgrammersTest1 {
    public int solution(int[][] jobs) {
        int n = jobs.length; // 요청 개수

        // 현재 남은 요청중에 가장 빨리 시작하는 순서
        PriorityQueue<int[]> request = new PriorityQueue<>((o1, o2)->{
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        // request 넣기
        for(int [] job : jobs){
            request.add(job);
        }

        // pq -> 하드 디스크
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            if(o1[1] != o2[1]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int sum  = 0; // 소요 시간 누적
        int time = 0; // 시간 기록

        Stack<int[]> stack = new Stack<>(); // 임시 저장용 stack

        while(!request.isEmpty() || !pq.isEmpty()){
            // 작업 수행 x -> 먼저 요청이 들어온 작업
            if(pq.isEmpty()){
                int [] temp = request.poll();
                sum += temp[1]; // 대기 없이 소요시간만 추가
                time = Math.max(time + temp[1], temp[0] + temp[1]);
            }
            // 작업이 있으면 가장 소요 시간이 적은 작업 수행
            else{
                int [] temp = pq.poll();
                sum += temp[1] + time - temp[0];
                time = Math.max(time + temp[1], temp[0] + temp[1]);
            }
            int size = request.size();
            // 현재 작업이 끝나는 시간까지 요청이 있는 경우 -> 추가
            for(int i = 0; i < size; i++){
                if(request.peek()[0] <= time) pq.add(request.poll());
                else stack.add(request.poll());
            }
            while(!stack.isEmpty()) request.add(stack.pop());
        }
        // 평균 시간 반환 -> 누적 시간 / 작업 개수
        return sum / n;
    }
}
