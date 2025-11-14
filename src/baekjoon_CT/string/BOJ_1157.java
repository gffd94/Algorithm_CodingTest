package baekjoon_CT.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        int maxCount = -1;
        char maxChar = '?';
        for (char i = 'A'; i <= 'Z'; i++) {
            int count = getCount(str, i);
            if(count > maxCount){
                maxCount = count;
                maxChar = i;
            }
            else if(count == maxCount){
                maxChar = '?';
            }
        }

        System.out.println(maxChar);
        br.close();

    }

    private static int getCount(String str, char alpha) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == alpha) count++;
        }
        return count;
    }
}
