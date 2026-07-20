            BigInteger a = new BigInteger(A);
            BigInteger b = new BigInteger(B);

            // 합
            BigInteger sum = a.add(b);
            // 차
            BigInteger sub = a.subtract(b).abs();




            if(A.equals("0") && B.equals("0")) break;

            String B = br.readLine();
            if(B == null) break;
            B = B.trim();
            A = A.trim();
            if(A == null) break;
            String A = br.readLine();
        StringBuilder sb = new StringBuilder();

        while(true) {
import java.util.*;
import java.math.*;
import java.io.*;

public class solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            sb.append(sum).append("\n");
            sb.append(sub).append("\n");
        }

        System.out.print(sb);
    }
}