import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 직전 저장소
        int[] maxDp = new int[3];
        int[] minDp = new int[3];
        // 최대 최소 저장소 
        int[] newMaxDp = new int[3];
        int[] newMinDp = new int[3];

        // 초기값 세팅
        st = new StringTokenizer(br.readLine());
        maxDp[0] = minDp[0] = Integer.parseInt(st.nextToken());
        maxDp[1] = minDp[1] = Integer.parseInt(st.nextToken());
        maxDp[2] = minDp[2] = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 현재 행 최대값 갱신
            newMaxDp[0] = a + Math.max(maxDp[0],maxDp[1]);
            newMaxDp[1] = b + Math.max(Math.max(maxDp[0],maxDp[1]) , maxDp[2]);
            newMaxDp[2] = c + Math.max(maxDp[1],maxDp[2]);

            // 현재 행 최소값 갱신
            newMinDp[0] = a + Math.min(minDp[0] , minDp[1]);
            newMinDp[1] = b + Math.min(Math.min(minDp[0] , minDp[1]) , minDp[2]);
            newMinDp[2] = c + Math.min(minDp[1], minDp[2]);

            maxDp = Arrays.copyOf(newMaxDp,3);
            minDp = Arrays.copyOf(newMinDp,3);

        }

        int maxAnswer = Math.max(Math.max(maxDp[0], maxDp[1]) , maxDp[2]);
        int minAnswer = Math.min(Math.min(minDp[0], minDp[1]) , minDp[2]);

        System.out.println(maxAnswer+ " " + minAnswer);
        
        
    }


}