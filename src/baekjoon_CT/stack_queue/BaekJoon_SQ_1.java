package baekjoon_CT.stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CodeTest1 {

    /* 10799 쇠막대기
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ch = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        long piece = 0L;
        
        for (int i = 0; i < ch.length; i++) {
            if( ch[i] == '('){
                stack.push('(');
            }else { // 레이저 끝
                if (ch[i-1] == '(') {
                    stack.pop(); // 레이저 '('
                    piece += stack.size();
                }else { // 막대 끝
                    stack.pop();
                    piece += 1;
                }
            }
        }

        System.out.println( piece);
    }
}
