
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int open1 = Integer.parseInt(st.nextToken());
        int open2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        orders = new int[m];

        for(int i = 0; i < m; i++) {
            orders[i] = Integer.parseInt(br.readLine());
        }

        // 💡 DP 배열을 -1로 초기화 (방문하지 않았음을 표시)
        for(int[][] arr2D : dp) {
            for(int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        // 💡 이제 전역 변수를 갱신하는 게 아니라, 최종 최솟값을 리턴받아 출력합니다.
        System.out.print(dfs(0, open1, open2));
    }

    // 💡 count 누적 누더기 변수 대신, 최종 결괏값을 return하는 구조로 변경
    private static int dfs(int index, int left, int right) {
        // 탈출조건
        if(index == m) {
            return 0;
        }

        // 💡 이미 계산한 적이 있다면 그 결괏값을 즉시 재활용 (시간 초과의 핵심 해결책)
        if(dp[index][left][right] != -1) {
            return dp[index][left][right];
        }

        int target = orders[index];

        // 왼쪽문을 이동하는 경우의 비용 + 그 다음 탐색 결과
        int leftMove = Math.abs(left - target) + dfs(index + 1, target, right);

        // 오른쪽문을 이동하는 경우의 비용 + 그 다음 탐색 결과
        int rightMove = Math.abs(right - target) + dfs(index + 1, left, target);

        // 두 갈래길 중 최솟값을 현재 상태의 DP 테이블에 기록하며 리턴
        return dp[index][left][right] = Math.min(leftMove, rightMove);
    }
}