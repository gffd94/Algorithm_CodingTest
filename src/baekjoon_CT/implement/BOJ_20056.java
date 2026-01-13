package baekjoon_CT.implement;

import java.io.*;
import java.util.*;

public class BOJ_20056 {
    // 파이어볼 정보를 담을 클래스
    static class Fireball {
        int r, c, m, s, d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N, M, K;
    static ArrayList<Fireball> fireballs = new ArrayList<>();
    static ArrayList<Fireball>[][] map;

    // 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 맵 초기화 (나중에 쓰기 위해 미리 선언만)
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) map[i][j] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        // K번 마법 시전
        while (K-- > 0) {
            move();
            divide();
        }

        // 결과 계산
        int totalMass = 0;
        for (Fireball fb : fireballs) {
            totalMass += fb.m;
        }
        System.out.println(totalMass);
    }

    // 1단계: 모든 파이어볼 이동
    static void move() {
        // 맵 클리어 (이전 턴 데이터 삭제)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) map[i][j].clear();
        }

        for (Fireball fb : fireballs) {
            // [핵심] 원형 맵 이동 공식
            int nr = (fb.r + dr[fb.d] * (fb.s % N) + N) % N;
            int nc = (fb.c + dc[fb.d] * (fb.s % N) + N) % N;

            // 정보 갱신 및 맵에 배치
            fb.r = nr;
            fb.c = nc;
            map[nr][nc].add(fb);
        }
    }

    // 2단계: 합체 및 분열
    static void divide() {
        ArrayList<Fireball> newFireballs = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c].isEmpty()) continue;

                // 1. 파이어볼이 1개인 경우 -> 그대로 생존
                if (map[r][c].size() == 1) {
                    newFireballs.add(map[r][c].get(0));
                    continue;
                }

                // 2. 파이어볼이 2개 이상인 경우 -> 합체 후 4개 분열
                int sumM = 0, sumS = 0;
                int count = map[r][c].size();
                boolean allEven = true;
                boolean allOdd = true;

                for (Fireball fb : map[r][c]) {
                    sumM += fb.m;
                    sumS += fb.s;
                    if (fb.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int newM = sumM / 5;
                if (newM == 0) continue; // 질량 0이면 소멸

                int newS = sumS / count;
                int startDir = (allEven || allOdd) ? 0 : 1; // 방향 결정

                for (int i = 0; i < 4; i++) {
                    newFireballs.add(new Fireball(r, c, newM, newS, startDir + i * 2));
                }
            }
        }

        // 다음 턴을 위해 리스트 갱신
        fireballs = newFireballs;
    }
}

