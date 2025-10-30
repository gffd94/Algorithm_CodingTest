package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = br.readLine().split(" ");
        int S = Integer.parseInt(str1[0]);
        int P = Integer.parseInt(str1[1]);

        char[] crr = br.readLine().toCharArray();

        String[] str2 = br.readLine().split(" ");
        int[] minCount = new int[4]; // 최소 요구 갯수 배열
        int checkCount = 0;
        for (int i = 0; i < 4; i++) {
            minCount[i] = Integer.parseInt(str2[i]);
            if(minCount[i] == 0) checkCount++;
        }

        // 현재 윈도우 문자 개수
        int[] currnetCount = new int[4];

        // 첫 윈도우 생성
        for (int i = 0; i < P; i++) {
            int idx = getIndex(crr[i]);
            currnetCount[idx]++;

            if(currnetCount[idx] == minCount[idx]) checkCount++;

        }

        int answer = 0;
        // 첫 번쨰 윈도우가 조건을 만족 시키느냐
        if( checkCount == 4 ) answer++;

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int addIdx = getIndex(crr[i]);
            currnetCount[addIdx]++;

            if(currnetCount[addIdx] == minCount[addIdx]) checkCount++;

            // 왼쪽 문자제거
            int removeIdx = getIndex(crr[i - P]);
            if(currnetCount[removeIdx] == minCount[removeIdx]) checkCount--;

            currnetCount[removeIdx]--;

            if(checkCount == 4) answer++;
        }

        System.out.println(answer);
    }

    private static int getIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
            default: return -1;
        }
    }
}
