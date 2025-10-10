package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        double avg = 0.0;
        for (int i = 0; i < N; i++) {
                avg += (double) nums[i]/max*100;
        }

        System.out.println(avg/N);
    }
}
