package baekjoon_CT.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919_refactoring {

    // 중복 되는 부분 함수화
    public static int[] getCount(String str){
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int answer = 0;
        int[] countA = getCount(a);
        int[] countB = getCount(b);

        // Math.abs = 나온 결과값이 절대값으로 양수로 나오게 됌 
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(countA[i] - countB[i]);
        }

        System.out.println( answer);
        br.close();

    }
}
