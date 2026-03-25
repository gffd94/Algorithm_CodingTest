import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long[] cables = new long[K];
        for(int i = 0; i < K; i++){
            cables[i] = Long.parseLong(br.readLine());
        }

        long lt = 1;
        // rt = 갖고있는 케이블 중 최대 길이
        long rt = 0;
        for(int i = 0; i<K; i++){
            rt = Math.max(rt, cables[i]);
        }

        while(lt<=rt){
            long mid = (lt+rt)/2;
            int part = 0;
            for(int i = 0; i< K; i++){
                part += cables[i]/mid;
            }
            // 가능하면 더 늘려보기
            if(part >= N){
                lt = mid + 1;
            }else{
            // 불가능하면 줄여보기
                rt = mid -1;
            }
            
        }

        System.out.println(rt);
        
        
    }


}