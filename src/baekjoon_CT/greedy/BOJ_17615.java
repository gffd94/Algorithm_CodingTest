package baekjoon_CT.greedy;

import java.util.*;
import java.io.*;

public class BOJ_17615 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        List<Integer> buleCount = new ArrayList<>();
        List<Integer> redCount = new ArrayList<>();

        // 시작 색깔 (비교군)
        char currentColor = balls.charAt(0);
        int count = 1;

        // 문자열 돌면서 색깔별 갯수 파악
        for(int i = 1; i < N; i++){
            if(balls.charAt(i) == currentColor){
                count++;
            }else{
                // 색이 바뀌면 이전 그룹 저장
                if(currentColor == 'R') redCount.add(count);
                else buleCount.add(count);

                // 색이 바뀌었으니까 비교군 초기화
                currentColor = balls.charAt(i);
                count = 1;
            }
        }

        // 마지막 그룹 저장
        if(currentColor == 'R') redCount.add(count);
        else buleCount.add(count);

        // 총개수 구하기
        int totalRed = 0;
        for(int i : redCount) totalRed += i;

        int totalBlue = 0;
        for(int i : buleCount) totalBlue += i;

        // 4가지 경우의 수 계산
        int answer = Integer.MAX_VALUE;
        int move = totalRed;
        // 빨간공을 왼쪽으로 모으기
        if(balls.charAt(0) == 'R') {
            move -= redCount.get(0); // 첫번째 빨강그룹 빼기
        }
        answer = Math.min(answer, move);
        // 빨간공을 오른쪽으로 모으기
        move = totalRed;
        if(balls.charAt(N-1) == 'R') {
            move -= redCount.get(redCount.size()-1); // 마지막 빨강 그룹 빼기
        }
        answer = Math.min(answer, move);
        // 파란공을 왼쪽으로 모으기
        move = totalBlue;
        if(balls.charAt(0) == 'B') {
            move -= buleCount.get(0);
        }
        answer = Math.min(answer, move);
        // 파란공을 오른쪽으로 모으기
        move = totalBlue;
        if(balls.charAt(N-1) == 'B'){
            move -= buleCount.get(buleCount.size()-1);
        }
        answer = Math.min(answer, move);

        System.out.println(answer);

    }

}
