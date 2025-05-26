package programmers_CT.test2;

import java.util.Scanner;

public class ProgrammersTest1 {
    public static boolean solution(int x){
        int num = x;
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        if(x % sum == 0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(solution(x));
    }

}
