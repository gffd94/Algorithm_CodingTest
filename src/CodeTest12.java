import java.util.Scanner;
import java.util.Stack;

public class CodeTest12 {

    public  static String solution(String string){
        String annswer = "YES";
        Stack<Character> stack = new Stack<>();

        for (char x : string.toCharArray()){
            if(x=='(') stack.push(x);
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        if(!stack.isEmpty()) return "NO";

        return annswer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.next();
        System.out.println(solution(string));
    }
}
