import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        while(K>0){

            if( K / coins[N-1] > 0) {
                result += K / coins[N-1];
                K = K % coins[N-1];
            } 

            N--;
            
        }

        System.out.println(result);
        
    }


}