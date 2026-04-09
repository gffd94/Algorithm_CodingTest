import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        int answer = 0;

        //jobs를 요청 시각에 따라 정렬 (오름차순)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 소요시간을 기준으로 대기 시간 큐 넣기
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);

       int time = 0;
       int total = 0;
       int idx = 0;

       while(idx < jobs.length || !pq.isEmpty()) {

        // 현재 시간 까지 요청 들어온 작업을 pq에 넣기
        while(idx < jobs.length && jobs[idx][0] <= time) {
            pq.offer(jobs[idx]);
            idx++;
        }

        if(pq.isEmpty()) {
            time = jobs[idx][0];
        } else {
            int[] job = pq.poll();
            time += job[1];
            total += time - job[0];
        }


       }

        answer = total/jobs.length;

        return answer;
    }
}