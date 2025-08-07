package programmers_CT.test5;

import java.util.Stack;

public class ProgrammersTest2 {
    static public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String str = s.substring(i) + s.substring(0, i);

            for(int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if(stack.isEmpty()){
                    stack.push(ch);
                } else if (ch == ')' || stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' || stack.peek() == '{') {
                    stack.pop();
                } else if (ch == '[' || stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            if (stack.isEmpty()) answer++;

        }

        return answer;
    }

}
