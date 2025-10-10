package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11720_refactoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int sum = 0;
        for (char c : str.toCharArray()) {
            sum += c - '0';  // 훨씬 효율적인 방법
        }

        System.out.println(sum);
    }
}