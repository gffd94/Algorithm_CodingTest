package baekjoon_CT.binary_search;

import java.util.*;
import java.io.*;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력 및 배열 생성
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 위한 정렬
        Arrays.sort(array);

        // M 입력 및 탐색 수행
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(array, target)).append("\n");
        }

        System.out.print(sb);
    }

    /**
     * 이분 탐색을 통해 배열에 타겟 값이 존재하는지 확인합니다.
     * @param array 정렬된 정수 배열
     * @param target 찾고자 하는 값
     * @return 존재하면 1, 존재하지 않으면 0
     */
    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // 오버플로우 방지

            if (array[mid] == target) {
                return 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

}
