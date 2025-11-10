package baekjoon_CT.stack_queue;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_refactoring {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        int next = 1;
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            while (next <= target) {
                stack.push(next++);
                sb.append("+\n");
            }

            if (stack.peek() != target || stack.isEmpty()) {
                flag = false;
                break;
            }

            stack.pop();
            sb.append("-\n");

        }

        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb.toString());
        }

    }
}
