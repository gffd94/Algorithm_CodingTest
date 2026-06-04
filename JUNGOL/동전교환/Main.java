
        dp[0] = 0;
        for(int i = 1; i < price+1; i++) {
            for(int j = 0; j < n; j++) { // 각 동전들을 선택했을 때
        // 1 ~ price 까지 순환
                if( i - coin[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        if(dp[price] == price+1){
            System.out.print("impossible");
        }else{
            System.out.print(dp[price]);
        }


    }
}
        }
            dp[i] = price+1;
            coin[i] = Integer.parseInt(st.nextToken());
        }
        int price = Integer.parseInt(br.readLine());

        // x 금액을 만드는 최소 동전 수 -> 최대수로 세팅
        int[] dp = new int[price+1];
        for(int i = 1; i <= price; i++) {
        for(int i = 0; i < n; i++) {