package baekjoon_CT.stack_queue;

import java.io.*;
import java.util.*;

public class BaekJoon_SQ_2 {

    /*  1874 - 수열스택
    * */
    public static void main(String[] args) throws IOException {
        // BufferedReader 사용 이유 : Buffer로 한번에 하는게 디스크 비용 아낌
        // StringBUilder 사용 이유 : 제출 결과 String 객체에서 추가하고 이런게 더 편하고 hashcode값을 생각하면 메모리 비용 아낌
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int next = 1;
        boolean flag = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            // target 까지 push
            while (next <= target) {
                stack.push(next++);
                sb.append("+\n");
            }
            // 현재 peek가 target이면 pop가능
            if(stack.isEmpty() || stack.peek() != target){
                flag = false;
                break;
            }
            stack.pop();
            sb.append("-\n");
        }

        if(!flag){
            System.out.println("NO");
        }else {
            System.out.println(sb.toString());
        }
    }
}
