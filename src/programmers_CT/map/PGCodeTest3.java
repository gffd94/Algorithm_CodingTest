package programmers_CT.map;

import java.util.HashMap;
import java.util.Map;

public class PGCodeTest3 {

    public static int solution(String[][] clothes){
        Map<String,Integer> map = new HashMap<>();

        // 종류별 개수 구하기
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type,map.getOrDefault(type,0)+1);

        }
        // 수학적 계산
        // 각 개수의 +1, 모두 곱한다.
        int answer = 1;
        var iterator = map.values().iterator();
        while(iterator.hasNext()){
            answer *= iterator.next() +1;
        }
        // -1 해서 리턴한다.
        return answer -1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
}
