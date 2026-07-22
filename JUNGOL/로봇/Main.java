            // 직진 파트
            for(int k = 1; k <= 3; k++) {
                int nr = r + dx[dir] * k;
            if(r == end[0] && c == end[1] && dir == end[2]) {
                return cnt;
                
            }


             // 종료 조건
            int cnt = curr[3];
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dir = curr[2];
                int nc = c + dy[dir] * k;

                // 1은 벽 -> 진행 불가 break;
                if(nr < 1 || nr > n || nc < 1 || nc > m || maps[nr][nc] == 1) break;

                // 같은 횟수로 왔거나 더적은 횟수로 왔을때 queue에 집어넣기
                // <= 방향이 다음진행에 영향을 끼치기 때문에 
                if(!visited[nr][nc][dir]) {
                    visited[nr][nc][dir] = true;
                    queue.offer(new int[]{nr,nc,dir,cnt+1});
                }
            }

            // 방향 전환파트
            int goleft = leftDir(dir);
            int goright = rightDir(dir);

            // 왼쪽 회전한 (좌표 + 새 방향)을 방문한 적 없다면 큐에 투입!
            if(!visited[r][c][goleft]) {
                visited[r][c][goleft] = true;
                queue.offer(new int[]{r, c, goleft, cnt + 1});
            }

            // 오른쪽 회전한 (좌표 + 새 방향)을 방문한 적 없다면 큐에 투입!
            if(!visited[r][c][goright]) {
                visited[r][c][goright] = true;
                queue.offer(new int[]{r, c, goright, cnt + 1});
            }

           
        }

        return -1;
    }
