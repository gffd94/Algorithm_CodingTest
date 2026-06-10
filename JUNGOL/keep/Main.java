        q.offer(new int[]{x,y,0});
        visited[x][y] = true;
        int maxDist = 0;


    static int bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
                    dist = bfs(i,j,visited);
                    answer = Math.max(answer, dist);
                }
            }
        }

    }

                if(khan == 'L') {
                    visited = new boolean[r][c];
                int dist = 0;
            for(int j = 0; j < c; j++) {
                char khan = map[i][j];
        boolean[][] visited;

        for(int i = 0; i < r; i++) {

        map = new char[r][c];
        for(int i = 0; i < r; i++) {
            String line = br.readLine().trim();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int answer = 0;

        System.out.println(answer);
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
            maxDist = Math.max(maxDist, dist);

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || nx >= r || ny < 0 || ny >= c 
                        || visited[nx][ny] || map[nx][ny] != 'L') continue;