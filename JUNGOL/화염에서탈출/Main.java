
        while(!q.isEmpty()) {

            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ctime = cur[2];

            // D 도착인경우
            if(maps[cx][cy] == 'D') {
                return ctime;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 범위 밖 && 바위 진행 X
                if(nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] == true || maps[nx][ny] == 'X' ) continue;

                // 불이 먼저 도달
                if(fireTime[nx][ny] != -1 && fireTime[nx][ny] <= ctime+1) continue;

                visited[nx][ny]= true;
                q.offer(new int[]{nx,ny,ctime + 1});
            }
        }

        // 만약 도착 못하는 경우 
        return -1;
    }
}