package baekjoon_CT.binary_search;

import java.io.*;
import java.util.*;

public class BOJ_3079 {

    static int N;
    static long M;
    static long[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");

        N = Integer.parseInt(split[0]);
        M = Long.parseLong(split[1]);
        times = new long[N];
        // T만큼 주어졌을 때 몇 명을 심사할 수 있는가? 를 기준으로 놓고 생각.
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(times);
        long lt = 1;
        long rt = M * times[0];
        long answer = Long.MAX_VALUE; // 최대 시간 수 초기화

        while(lt <= rt) {
            long mid = (lt + rt) / 2;
            long value = calculatePeople(mid);

            if(value < M){
                lt = mid + 1;
            }else {
                rt = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        System.out.println(answer);
    }

    // 주어진 시간(mid)동안 M명을 처리할 수 있는지 계산하는 함수
    private static long calculatePeople(long mid) {
        long count = 0;
        for (long time : times) {
            count += mid / time;

            // 이미 M명을 넘었으면 더 계산할 필요가 없음( 오버플로우 방지 )
            if(count >= M) break;
        }
        return count;
    }
}
