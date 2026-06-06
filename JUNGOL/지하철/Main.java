        dist[1]= 0;
        // 1번부터 시작

        for(int i = 1; i <= n ; i++) {
        // n까지 노드를 확정짓기 위해 반복
            for(int j = 1; j <= n; j++) {
            visited[cur] = true;
            int cur = -1;
                if(!visited[j] && (cur == -1 || dist[j] < dist[cur] )){
            }
                    cur = j;
                }
            // 방문 안한 곳중에 dist가 가장 최소 곳

            for(int next = 1; next <= n; next++) {

                if(subway[cur][next] == 0) {
            }
                    continue;
                }

                if(dist[next] > dist[cur] + subway[cur][next]) {
                    dist[next] = dist[cur] + subway[cur][next];
                }
                    prev[next] = cur;
                    // next는 cur에서 왔다.
        }


        // 경로 역추적용 
        int[] prev = new int[n+1];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        System.out.println(dist[m]);
        while(!stack.isEmpty()) {
        // 출력

        Stack<Integer> stack = new Stack<>();
        int point = m;
        while(point != -1) {
            stack.push(point);
        }
            point = prev[point];
        boolean[] visited = new boolean[n+1];
        int INF = 99999;
        // 다익스트라 방문처리 (다신안봄)
        // INF = 최대시간
        int[] dist = new int[n+1];
            System.out.print(stack.pop() + " ");