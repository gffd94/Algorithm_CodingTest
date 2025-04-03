package programmers_CT.map;
import java.util.HashMap;

public class PGCodeTest1 {

        public int solution(int[] nums) {
            int answer = 0;

            HashMap<Integer,Integer> list = new HashMap<>();
            for (int x : nums) {
                // x에 값을 집어넣는다
                // 만약 x 값이 있다면 해당 값을 반환하고 없다면 기본값으로 0을 설정한다
                list.put(x,list.getOrDefault(x,0)+1);
            }

            int len = nums.length/2;
            int len1 =list.keySet().size();
            if(len>len1){
                answer = len1;
            }else {
                answer = len;
            }

            return answer;
        }
    }

