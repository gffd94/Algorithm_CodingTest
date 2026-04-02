import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int answer = 0;
        for(int rt = 0; rt < N; rt++){
            sum += arr[rt];
            
            while(sum>M) {
                sum -= arr[lt];
                lt++;
            }

            if(sum == M) answer++;

        }

        System.out.println(answer);

    }

}
