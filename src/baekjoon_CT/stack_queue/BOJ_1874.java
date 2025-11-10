package baekjoon_CT.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if( arr[i] >= num) {
                while (arr[i] >= num) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }else {
                int tmp = stack.pop();
                if ( arr[i] < tmp) {
                    System.out.println("NO");
                    flag = false;
                    break;
                } else {
                    sb.append("-\n");
                }
            }


        }

        if(flag){
            System.out.println(sb.toString());
        }


    }
}
