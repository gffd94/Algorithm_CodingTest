package baekjoon_CT.array;

import java.util.Scanner;

public class BOJ_2018 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0 , lt = 0 , sum = 0;

        for (int rt = 0; rt < N; rt++) {
            sum += rt  + 1;

            while (sum > N && lt <= rt) {
                sum -= lt + 1;
                lt++;
            }

            if (sum == N) {
                count++;
            }

        }

        System.out.println( count);
    }
}
