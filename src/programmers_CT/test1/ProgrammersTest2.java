package programmers_CT.test1;

import java.util.ArrayList;
import java.util.List;

public class ProgrammersTest2 {

    public static int[] solution(int [] arr){
        List<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]){
                answer.add(arr[i]);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int [] arr = {1,1,3,3,0,1,1};
        for (int i : solution(arr)) {
            System.out.print(i+" ");
        }
    }
}
