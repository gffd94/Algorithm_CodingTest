
            // 지정된 그룹 수 M보다 작거나 같게 만들 수 있다면 가능!
            if(count <= m) {
                answer = mid; // 최댓값의 최솟값 후보 저장
                rt = mid - 1; // 더 작은 최댓값 탐색
            } else {
                lt = mid + 1; // 그룹이 너무 많이 나뉘므로 기준(mid)을 높임
            }
        }

        // 최댓값 출력
        System.out.println(answer);

        // [수정] 구슬 개수 역추적 및 출력 로직 완성
        ArrayList<Integer> array = new ArrayList<>();
        int check = 0;
        int cnt = 0;
        int remainGroup = m;

        for(int i = 0; i < n; i++) {
            check += balls[i];
            cnt++;
            
            int remainBalls = n - i - 1; // 현재 구슬을 제외하고 뒤에 남은 구슬 수

            // 1. 현재 누적합이 최솟값(answer)을 넘어가거나
            // 2. 뒤에 남은 구슬들이 각각 최소 1개씩 그룹을 가져야만 하는 상황일 때 (남은 구슬 수 == 남은 그룹 수 - 1)
            if(check > answer || remainBalls < remainGroup - 1) {
                // 현재 구슬을 넣기 전까지를 한 그룹으로 묶음
                check -= balls[i];
                cnt--;
                array.add(cnt);
                
                // 현재 구슬부터 다시 새 그룹 시작
                check = balls[i];
                cnt = 1;
                remainGroup--; 
            }
        }
        array.add(cnt); // 마지막 남은 그룹 추가

        // 출력 생성
        StringBuilder sb = new StringBuilder();
        for(int x : array) {
            sb.append(x).append(" ");
        }
        System.out.print(sb.toString().trim());
    }
}