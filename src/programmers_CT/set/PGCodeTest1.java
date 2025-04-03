package programmers_CT.set;

import java.util.ArrayList;
import java.util.List;

public class PGCodeTest1 {

    public static int[] solution(int[] arr){
        List<Integer> answer = new ArrayList<>();

        int idx = -1;
        for (int x : arr) {
            if(x == idx) continue;
            idx = x;
            answer.add(x);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        for (int x : solution(arr)) {
            System.out.print(x+" ");
        }
    }
}
