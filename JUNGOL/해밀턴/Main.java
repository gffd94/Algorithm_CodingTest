    static void dfs(int cur, int depth, int costSum) {

        
        System.out.println(answer);
    }
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1부터 탐색 시작.
        visited[1] = true;
        // 현재위치, 거리, 총비용
        dfs(1,1,0);
        for(int i = 1; i <= n; i++) {

        // 최소비용이 아닐경우 탐색 불필요
        if(costSum >= answer) {
            return;
        }


        // 종료조건
        if(depth == n) {
            // 복귀 길이 0이 아닌경우
            if(cost[cur][1] != 0) {
                answer = Math.min(answer, cost[cur][1] + costSum);
            }
        }

        // 탐색
        for(int i = 1; i <= n; i++) {
            // 방문여부
            if(visited[i]) continue;

            // 갈 수 있는 길
            if(cost[cur][i] == 0) continue;

            visited[i] = true;
            dfs(i, depth+1, costSum+cost[cur][i]);
            visited[i] = false;
            
        }


            return;