package baekjoon_CT.greedy;
import java.io.*;
import java.util.*;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;
        String str = br.readLine();
        String[] parts = str.split("[-]");
        for(int i = 0; i < parts.length; i++) {
            int sum = mySum(parts[i]);
            if(i==0) answer += sum;
            else answer -= sum;
        }

        System.out.println( answer);

    }

    private static int mySum (String s) {
        int sum = 0;
        String[] temp = s.split("[+]");
        for(int i = 0; i < temp.length; i++) sum += Integer.parseInt(temp[i]);

        return sum;
    }


}
