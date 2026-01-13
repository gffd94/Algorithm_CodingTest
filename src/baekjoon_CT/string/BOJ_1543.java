package baekjoon_CT.string;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_1543 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String doc = sc.nextLine();
        String word = sc.nextLine();

        int count = 0;
        int startIndex = 0;

        while (true){
            int finalIndex = doc.indexOf(word, startIndex);
            if(finalIndex < 0) break;
            count++;
            startIndex = finalIndex + word.length();
        }

        System.out.println(count);

    }
}
