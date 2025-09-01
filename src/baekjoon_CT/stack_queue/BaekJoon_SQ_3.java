package baekjoon_CT.stack_queue;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon_SQ_3 {

    /* 17298 오큰수 문제
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while(!stack.isEmpty() && A[stack.peek()] < A[i] ){
                answer[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
