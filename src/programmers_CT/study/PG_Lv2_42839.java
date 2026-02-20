package programmers_CT.study;

import java.util.*;

public class PG_Lv2_42839 {

    static Set<Integer> result = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // 종이 조각으로 숫자 만들기 (순열-> 재귀함수를 통해 구현)
        permutation(numbers, "");
        for(int num : result){
            if(isPrime(num)) answer++;
        }

        // 소수 : 1과 자기 자신을 제외하고는 나눠지는 수가 없는 수


        return answer;
    }

    private static void permutation(String remaining, String current){
        if(!current.isEmpty()){
            result.add(Integer.parseInt(current)); // 지금까지 만든 수 저장
        }

        for(int i = 0; i < remaining.length(); i++){
            String picked = String.valueOf(remaining.charAt(i));
            String rest = remaining.substring(0, i) + remaining.substring(i+1);
            permutation(rest, current + picked);
        }
    }

    private static boolean isPrime(int num){
        if(num<2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }

}
