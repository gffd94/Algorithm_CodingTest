package programmers_CT.study;
import java.util.*;

public class PG_Lv2_42586 {
    public int[] solution(int[] progresses, int[] speeds) {

        // progresses의 값을 남은 일자로 변환
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            int progress = 100 - progresses[i];
            int speed = speeds[i];

            double cal = (double) progress / speed;
            int day = (int) Math.ceil(cal);
            q.offer(day);
        }

        // 정답
        List<Integer> answerList = new ArrayList<>();

        if(!q.isEmpty()){
            // 처음 작업
            int maxDay = q.poll();
            int cnt = 1;

            while(!q.isEmpty()){
                int nextDay = q.poll();
                if(maxDay >= nextDay){
                    cnt++;
                }else{
                    answerList.add(cnt);
                    cnt = 1;
                    maxDay = nextDay;
                }
            }

            answerList.add(cnt);

        }

        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }


        return answer;
    }
}
