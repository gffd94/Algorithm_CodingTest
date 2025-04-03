package programmers_CT.map;

import java.util.HashMap;
import java.util.Map;

public class PGCodeTest2 {

    public static String solution(String[] participant, String[] completion){
        String answer = "";
            Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            int n = map.get(s)-1;
            if(n == 0){
                map.remove(s);
            }else {
                map.put(s,n);
            }

        }

        return map.keySet().iterator().next();
    }

    public static void main(String[] args) {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(participant, completion));
    }
}
