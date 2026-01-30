package baekjoon_CT.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_2550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        // 스위치 저장
        int[] switchArray = new int[N+1];
        // 정답 출력시 스위치 위치
        int[] answer = new int[N+1];
        st = new StringTokenizer(br.readLine());
        // 스위치 번호와 몇 번째 인덱스에 있는지
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            switchArray[num] = i+1;
            answer[i+1] = num;
        }

        // 전구 저장
        // [Fixed] 크기를 N으로 딱 맞춤 (0이 섞이지 않도록)
        int[] mappedBulb = new int[N];
        st = new StringTokenizer(br.readLine());
        // 해당 전구가 스위치 기준으로 몇번째 있는지
        for (int i = 0; i < N; i++) {
            mappedBulb[i] = switchArray[Integer.parseInt(st.nextToken())];
        }
        // LIS 알고리즘 (이분탐색)
        List<Integer> lis = new ArrayList<>();
        int[] trace = new int[N];
        for (int i = 0; i < N; i++) {
            int num = mappedBulb[i];
            if(lis.isEmpty() || lis.get(lis.size() -1) < num){
                lis.add(num);
                trace[i] = lis.size();
            }else {
                int idx = Collections.binarySearch(lis, num);
                if(idx < 0) idx = -(idx+1);
                lis.set(idx, num);
                trace[i] = idx + 1; //trace에 기록(인덱스기준)
            }
        }
        // 최대개수 출력
        System.out.println(lis.size());

        // 역추적
        List<Integer> result = new ArrayList<>();
        int targetLen = lis.size();
        for (int i = N-1; i >= 0; i--) {
            if(trace[i] == targetLen){
                result.add(answer[mappedBulb[i]]); // 해당 위치-> 실제 번호 반환
                targetLen--;
            }
        }

        // 오름차순 정렬 및 출력
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }
}
