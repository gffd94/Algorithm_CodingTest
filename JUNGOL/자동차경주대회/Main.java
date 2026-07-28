            for(int j = 0; j < i; j++) {
                // 주행 거리 n 보다 작은 거리 후보중
                if(dist[i]-dist[j] <= limit) {
                    // 그 중 최소 시간
                    if(dp[j]+times[i] < dp[i]) {
                        dp[i] = dp[j] + times[i];
                        repair[i] = j;
                    }
                }
            }
        }

        if(dp[n+1] == INF || dp[n+1] == 0) {
            System.out.print(0);
        } else {
            // 최소시간
            System.out.println(dp[n+1]);
            ArrayList<Integer> array = new ArrayList<>();
            int cur = repair[n+1];
            while(cur != 0) {
                array.add(cur);
                cur = repair[cur];
            }
            System.out.println(array.size());
            Collections.reverse(array);

            for(int x : array) {
                System.out.print(x+" ");
            }
        }

    }
}