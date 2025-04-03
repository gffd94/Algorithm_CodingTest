package programmers_CT.array_list;

import java.util.LinkedList;
import java.util.List;

public class PGCodeTest1_1 {
    // List로 풀어보기
    static int[] solution(long n){

        // list생성
        List<Integer> list = new LinkedList<>();
        // 12345를 거꾸로 나타내야함
        // 10을 나눈 나머지로 자리수를 끊어냄
        while (n>0){
            int x = (int)n%10;
            list.add(x);
            n = n/10;
            // 해당 로직을 반복
        }
        return list.stream().mapToInt(x -> x.intValue()).toArray();
    }

    public static void main(String[] args) {
        long n = 12345;
        for(int x : solution(n)){
            System.out.print(x+" ");
        }
    }
}
