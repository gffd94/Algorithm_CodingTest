package programmers_CT.test2;

import java.util.Scanner;

public class ProgrammersTest2 {

    public static int solution(String s) {
        int answer = 0;
        int diff = 0;
        char x = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (diff == 0) {
                x = s.charAt(i);
            }

            if (s.charAt(i) == x) {
                diff++;
            } else {
                diff--;
            }

            if (diff == 0) {
                answer++;
            }

        }

        if (diff != 0) {
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }

}
