import java.util.*;
import java.io.*;

public class Main {
 
    static int N;
    static long K;
    static int count;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        count = 1;
        kCounting();

        int start = (int)Math.pow(10, count-1);

        // 몇번 째 수인지
        int num = (int)(start + (K-1) / count);

        if(num > N) {
            System.out.print(-1);
            return;
        }
        
        // 그 수의 몇번 째 자리인지
        int pos = (int)((K-1)% count);

        System.out.print(String.valueOf(num).charAt(pos));

    }

    // K의 자리수 찾기
    private static void kCounting() {
        // 더이상 뺄 수 없는 구간
        while(K>0){
            long range = 9L * count * (long)Math.pow(10, count-1);
            if( K - range <= 0) break;
            K -= range;
            count++;
        }

    }



}
