            for(int j = 0; j < 101; j++) {

                int minHeight = downCount[i][j];
        for(int i = 0; i < 101; i++) {

            }
        }
                        downCount[i][j] = downCount[i][j+1] + 1; // 내 밑의 칸 숫자 + 1
                    }
                } else {
                    downCount[i][j] = 0; // 흰색칸이면 끊기니까 0
                }
                    } else {
                        downCount[i][j] = 1; 
                if(paper[i][j]) {
                    if(j == 100) {
                if(minHeight == 0) continue; // 높이 0이면 패스

                // 꼭지점 고정 후, 오른쪽으로 한칸씩 확장해 나가기
                for(int k = i; k < 101; k++) {
                    minHeight = Math.min(minHeight, downCount[k][j]);

                    // 반듯한 직사각형이 불가능 중단.
                    if(minHeight == 0) break;

                    int curWidth = k - i + 1;
                    int curArea = curWidth * minHeight;

                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }
            for(int j = 100; j >= 0; j--) {
        // 가로는 0부터 99까지 탐색
        for(int i = 0; i < 101; i++) {


        // 4. 최종 정답 출력
        System.out.println(maxArea);
    }
}