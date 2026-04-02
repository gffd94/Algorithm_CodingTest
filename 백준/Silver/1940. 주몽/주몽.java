import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = N-1;
        int sum = 0;
        int answer = 0;
        
        while(lt<rt) {
            sum = arr[lt] + arr[rt];

            if(sum < M) {
                lt++;
            }else if(sum == M){
                answer++;
                lt++;
                rt--;
            }else if(sum > M) {
                rt--;
            }

        }

        System.out.println(answer);

    }

}
