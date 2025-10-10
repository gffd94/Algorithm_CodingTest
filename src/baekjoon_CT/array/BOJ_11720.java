package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int sum = 0;
        for (char i : str.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(i));
        }

        System.out.println(sum);
    }
}
