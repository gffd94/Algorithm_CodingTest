package baekjoon_CT.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1919 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        int[] countA = new int[26];
        int[] countB = new int[26];


        for (int i = 0; i < a.length(); i++) {
            countA[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            countB[b.charAt(i) - 'a']++;
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            if(countA[i] > countB[i]) answer += countA[i] - countB[i];
            else if(countB[i] > countA[i]) answer += countB[i] - countA[i];
        }

        System.out.println( answer);
        br.close();

    }
}
