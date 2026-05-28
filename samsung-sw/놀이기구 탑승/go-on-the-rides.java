import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] score = {0, 1, 10, 100, 1000};
    static int N;
    static int[][] grid;
    static int[] order;
    static Set<Integer>[] likes;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N+1][N+1];
        // 입력 처리 → 학생 순서, likes 저장
        // 학생 탑승 순서
        order = new int[N*N];
        likes = new HashSet[N*N+1];

        for(int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            order[i] = Integer.parseInt(st.nextToken());   // 탑승 순서
            likes[order[i]] = new HashSet<>();             // ← 초기화 + 학생번호로 key
            for(int j = 0; j < 4; j++) {
                likes[order[i]].add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = 0;

        // 각 학생 순서대로
        for(int i = 0; i < N*N; i++) {
            // findBestSeat() → 최적 칸 찾기
            int[] bestSeat = findBestSeat(order[i]);
            // grid에 배치
            grid[bestSeat[0]][bestSeat[1]] = order[i];
        }

            // calcScore() → 최종 점수
            answer = calcScore();

        System.out.println(answer);

    }

    //findBestSeat(학생번호)
    static int[] findBestSeat(int student){
        int bestR = -1;
        int bestC = -1;
        int bestFriends = -1;
        int bestEmpty = -1;
        // 모든 빈 칸 후보 순회
        for(int row = 1; row <= N; row++) {
            for(int col = 1; col <= N; col++) {
                if(grid[row][col] != 0) continue;

                // 각 후보마다: (친구수, 빈칸수, 행, 열) 계산
                int cntFriends = countFriends(row, col, student);
                int cntEmpty = countEmpty(row, col);

                // 우선순위 비교해서 최적 반환
                if(bestFriends < cntFriends) {
                    bestR = row;
                    bestC = col;
                    bestFriends = cntFriends;
                    bestEmpty = cntEmpty;
                } else if(bestFriends == cntFriends) {
                    if(bestEmpty < cntEmpty) {
                        bestR = row;
                        bestC = col;
                        bestEmpty = cntEmpty;
                    } 
                }
            }
        }

        return new int[]{bestR, bestC};
    }



// countFriends(r, c, 학생번호)
    static int countFriends(int r, int c, int student) {
        // 4방향 이웃 중 grid에 앉은 좋아하는 친구 수
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && grid[nx][ny] != 0) {
                int friend = grid[nx][ny];
                if(likes[student].contains(friend)) count++; 
            }
        }

        return count;
    }

// countEmpty(r, c)
    static int countEmpty(int r, int c) {
        // 4방향 이웃 중 빈 칸 수 (격자 밖 제외)
        int count = 0;
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            
            if(nx >= 1 && nx <= N && ny >= 1 && ny <= N && grid[nx][ny] == 0) {
                count++;
            }

        }

        return count;

    }

// calcScore()
    static int calcScore(){
        int sum = 0;
        // 모든 칸 순회 → 학생별 인접 친구 수 → score 배열에서 누적합
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int count = 0;
                int student = grid[i][j];

                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 1 && nx <= N && ny >= 1 && ny <= N 
                            && likes[student].contains(grid[nx][ny]) ) {
                        count++;
                    }
                }

                sum += score[count];

            }

        }

        return sum;
    }
}

