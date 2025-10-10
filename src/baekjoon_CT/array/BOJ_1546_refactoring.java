package baekjoon_CT.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

        public class BOJ_1546_refactoring {
            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                int N = Integer.parseInt(br.readLine());
                StringTokenizer st = new StringTokenizer(br.readLine());

                int[] scores = new int[N];
                int max = 0;

                // 한 번의 반복으로 입력 받기 + 최댓값 찾기
                for (int i = 0; i < N; i++) {
                    scores[i] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, scores[i]);
                }

                // 새로운 평균 계산
                double sum = 0;
                for (int score : scores) {
                    sum += (double) score / max * 100;
                }

                System.out.println(sum / N);
            }
        }


