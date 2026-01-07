package baekjoon_CT.implement;

import java.io.*;
import java.util.*;

public class BOJ_17144 {

    static int R,C,T;
    static int[][] map;
    static int cleanerTop = -1, cleanerBottom = -1;
    // 상하좌우 배열
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) throws IOException {
        // 1.입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                // 입력받는 도중에 공기청정기 -1을 발견하면 위치 저장!
                if(map[i][j] == -1){
                    if(cleanerTop == -1) {
                        cleanerTop = i;
                    } else {
                        cleanerBottom = i;
                    }
                }
            }
        }

        // 2. T초 동안 시뮬레이션
        while (T-- > 0){
            spreadDust(); // 1. 미세먼지 확산
            operateAirPurifier(); // 2. 공기 청정기 작동
        }

        // 3. 결과 출력
        System.out.println(calcTotalDust());
    }

    private static int calcTotalDust() {
        // 전체 합 구하기
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0){ // -1 공청기 제외
                    sum += map[i][j];
                }
            }
        }

        return sum;
    }

    private static void operateAirPurifier() {
        // 순환 로직 구현
        // 1. 위쪽 공기청정기
        // 위에서 아래로 당김 [↓]
        for (int i = cleanerTop - 1; i > 0; i--){
            map[i][0] = map[i-1][0];
        }
        // 오른쪽에서 왼쪽으로 당김 [←]
        for (int i = 0; i < C-1; i++){
            map[0][i] = map[0][i+1];
        }
        // 아래에서 위로 당김 [↑]
        for (int i = 0; i < cleanerTop; i++){
            map[i][C-1] = map[i+1][C-1];
        }
        // 왼쪽에서 오른쪽으로 당김 [→]
        for (int i = C-1; i > 1; i--){
            map[cleanerTop][i] = map[cleanerTop][i-1];
        }
        map[cleanerTop][1] = 0;

        // 2. 아래쪽 공기청정기

        // 아래에서 위로 당김 [↑]
        for (int i = cleanerBottom + 1; i < R-1; i++){
            map[i][0] = map[i+1][0];
        }
        // 오른쪽에서 왼쪽으로 당김 [←]
        for (int i = 0; i < C-1; i++){
            map[R-1][i] = map[R-1][i+1];
        }
        // 위에서 아래로 당김 [↓]
        for (int i = R-1; i > cleanerBottom; i--){
            map[i][C-1] = map[i-1][C-1];
        }
        // 왼쪽에서 오른쪽으로 당김 [→]
        for (int i = C-1; i > 1; i--){
            map[cleanerBottom][i] = map[cleanerBottom][i-1];
        }
        map[cleanerBottom][1] = 0;


    }

    private static void spreadDust() {
        // 확산 로직 구현
        int[][] tempMap = new int[R][C]; // 임시 배열

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1){
                    tempMap[i][j] = -1; // 공청기 위치는 고정
                    continue;
                }

                // 확산 로직
                if(map[i][j] > 0){
                    int amount = map[i][j] / 5; // 확산되는 양
                    int cnt = 0; // 확산되는 방향 개수

                    for (int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        // 범위 체크 & 공청기가 아닌 곳으로만 확산
                        if(nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1){
                            tempMap[nx][ny] += amount;
                            cnt++;
                        }
                    }
                    // 확산하고 남은 먼지 = 기존 먼지 - (확산량 * 방향 개수)
                    // 자기 자리에 원래 있던 먼지 잔량을 더해줌
                    tempMap[i][j] += map[i][j] - (amount * cnt);
                }
            }
        }

        map = tempMap;
    }

}
