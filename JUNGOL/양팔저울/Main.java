            int w = weightArray[i];
            for(int j = 0; j <= 15000; j++) {
                if(dp[i-1][j] == true) {
                    // 0
                    dp[i][j] = true;
                    // + 더하기
                    if(w + j <= 15000) {
                // 직전의 무게 값이 사용 가능 한지
                        dp[i][j + w] = true;
                    }
                    // - 빼기
                    dp[i][Math.abs(j-w)] = true;
                }
            }
        }

        // dp 가지고 구슬무게 판단
        for(int i = 0; i < ballCount; i++) {
            int bw = ballsArray[i];

            if(bw > 15000) {
                System.out.print("N ");
            } else if(dp[weightCount][bw] == true) {
                System.out.print("Y ");
            } else { 
                System.out.print("N ");
            }
        }
    }