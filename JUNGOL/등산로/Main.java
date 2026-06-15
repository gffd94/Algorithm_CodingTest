        dist[tx][ty] = 0;
        
        // PQ에 dist 정상위치 넣기
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(tx, ty, 0));

        // PQ 탐색 ( 비용이 더 적으면 add )
        while(!pq.isEmpty()) {
            Point cp = pq.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cp.x + dx[i];
                int ny = cp.y + dy[i];

                if(nx >= 0 && nx < n+2 && ny >= 0 && ny < n+2) {
                    int curHigh = maps[cp.x][cp.y];
                    int nextHigh = maps[nx][ny];
                    int overCost = 0;
                    // 현재 값 - 다음 값 (양수 = 제곱, 음수 = 합)
                    if(curHigh > nextHigh) {
                        overCost = (curHigh - nextHigh) * (curHigh - nextHigh);
                    } else if(curHigh < nextHigh) {
                        overCost = nextHigh - curHigh;
                    }

                    int newCost = overCost + cp.cost;

                    if(newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        pq.offer(new Point(nx, ny, newCost));