package inflearn_CT.sort_search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeTest7 {

    public static char solution (int n, String s){
        char answer = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }

        return  answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        System.out.println(solution(n , s));
    }
}
