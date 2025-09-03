package baekjoon_CT.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon_BT_2 {

    static int N, M;
    static ArrayList<int[]> houses = new ArrayList<>();
    static ArrayList<int[]> choice = new ArrayList<>();
    static ArrayList<int[]> chickenStore = new ArrayList<>();
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) houses.add(new int[]{i,j});
                if (num == 2) chickenStore.add(new int[]{i,j});
            }
        }

        backTracking(0,0);
        System.out.println(MIN);

    }

    private static void backTracking(int count, int start){
        if(count == M){
            getDistance();
            return;
        }

        for (int i = start; i < chickenStore.size(); i++) {
            int[] now = chickenStore.get(i);
            choice.add(now);
            backTracking(count+1,i+1);
            choice.remove(now);
        }


    }

    private static void getDistance() {
        int totaldistance = 0;

        for (int[] home : houses) {
            int chickendistance = Integer.MAX_VALUE;
            for (int[] chicken : choice) {
                int distance = Math.abs(home[0] - chicken[0]) + Math.abs(home[1] - chicken[1]);
                if (distance < chickendistance) chickendistance = distance;
            }
            totaldistance += chickendistance;
        }
        if(totaldistance < MIN){
            MIN = totaldistance;
        }
    }
}
