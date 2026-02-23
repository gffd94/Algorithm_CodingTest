package programmers_CT.study;

import java.util.*;

public class PG_Lv2_42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];


        int w = 0 , h = 0;
        int multi = brown + yellow;
        int sum = (brown+4) / 2;
        // 인덱스 가 h 값이 w
        int[] divisors = new int[multi/2];

        for(int i = 1; i <= Math.sqrt(multi); i++){
            if(multi % i == 0){
                divisors[i] = multi/i;
            }
        }

        for(int i = 1; i < divisors.length; i++){
            if(i+divisors[i] == sum && divisors[i] >= i){
                answer[0] = divisors[i];
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
