package programmers_CT.test6;

import java.util.*;

public class Kakao_Q4 {
    // 그래프 표현 (배양체 간 연결 관계)
    private List<int[]>[] graph;
    // 감염 여부 추적
    private boolean[] infected;
    // 현재 감염된 배양체 수
    private int infectionCount;

    public int solution(int n, int infection, int[][] edges, int k) {
        // 그래프 초기화 (1-indexed)
        initializeGraph(n, edges);

        // 초기 감염 상태 설정
        infected = new boolean[n + 1];
        infected[infection] = true;
        infectionCount = 1;

        // k번의 행동 수행
        for (int i = 0; i < k; i++) {
            // 최적의 파이프 타입 선택
            int bestPipeType = selectBestPipeType();

            // 더 이상 감염시킬 배양체가 없으면 종료
            if (bestPipeType == 0) break;

            // 선택한 파이프로 감염 확산
            spreadInfection(bestPipeType);
        }

        return infectionCount;
    }

    // 그래프 초기화 메서드
    private void initializeGraph(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int type = edge[2];
            graph[x].add(new int[]{y, type});
            graph[y].add(new int[]{x, type});
        }
    }

    // 최적의 파이프 타입 선택 메서드
    private int selectBestPipeType() {
        int bestType = 0;
        int maxNewInfections = 0;

        // 각 파이프 타입(A=1, B=2, C=3)에 대해 추가 감염 수 계산
        for (int type = 1; type <= 3; type++) {
            int newInfections = calculateNewInfections(type);
            if (newInfections > maxNewInfections) {
                maxNewInfections = newInfections;
                bestType = type;
            }
        }

        return bestType;
    }

    // 특정 파이프 타입으로 추가 감염될 배양체 수 계산
    private int calculateNewInfections(int pipeType) {
        boolean[] visited = new boolean[infected.length];
        int newInfections = 0;
        Queue<Integer> queue = new LinkedList<>();

        // 현재 감염된 모든 배양체를 시작점으로 설정
        for (int i = 1; i < infected.length; i++) {
            if (infected[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        // BFS로 새로운 감염 계산
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] connection : graph[current]) {
                int nextNode = connection[0];
                int pipeType2 = connection[1];

                // 선택한 파이프 타입이고 아직 방문하지 않은 노드
                if (pipeType2 == pipeType && !visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);

                    // 아직 감염되지 않은 배양체라면 카운트
                    if (!infected[nextNode]) {
                        newInfections++;
                    }
                }
            }
        }

        return newInfections;
    }

    // 선택한 파이프 타입으로 감염 확산
    private void spreadInfection(int pipeType) {
        boolean[] visited = new boolean[infected.length];
        Queue<Integer> queue = new LinkedList<>();

        // 현재 감염된 모든 배양체를 시작점으로 설정
        for (int i = 1; i < infected.length; i++) {
            if (infected[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }

        // BFS로 감염 확산
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int[] connection : graph[current]) {
                int nextNode = connection[0];
                int pipeType2 = connection[1];

                // 선택한 파이프 타입이고 아직 방문하지 않은 노드
                if (pipeType2 == pipeType && !visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);

                    // 감염 확산
                    if (!infected[nextNode]) {
                        infected[nextNode] = true;
                        infectionCount++;
                    }
                }
            }
        }
    }

    // 테스트 메서드
    public static void main(String[] args) {
        Kakao_Q4 solution = new Kakao_Q4();

        // 예제 테스트
        int n = 10;
        int infection = 1;
        int[][] edges = {
            {1, 2, 1}, {1, 3, 1}, {1, 4, 3}, {1, 5, 2},
            {5, 6, 1}, {5, 7, 1}, {2, 8, 3}, {2, 9, 2}, {9, 10, 1}
        };
        int k = 2;

        int result = solution.solution(n, infection, edges, k);
        System.out.println("최대 감염 배양체 수: " + result);  // 6 출력 예상
    }
}
