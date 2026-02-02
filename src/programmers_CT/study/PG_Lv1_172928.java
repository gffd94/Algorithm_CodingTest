package programmers_CT.study;

class PG_Lv1_172928 {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;        // 세로 길이 (행 개수)
        int W = park[0].length();   // 가로 길이 (열 개수)

        int curX = 0; // 현재 행 (Row) - 세로 위치
        int curY = 0; // 현재 열 (Col) - 가로 위치

        // 1. 시작점(S) 찾기
        for (int i = 0; i < H; i++) {
            if (park[i].contains("S")) {
                curX = i;
                curY = park[i].indexOf("S");
                break;
            }
        }

        // 2. 명령 수행
        for (String route : routes) {
            String[] parts = route.split(" ");
            String op = parts[0];
            int n = Integer.parseInt(parts[1]);

            // 현재 위치를 건드리지 말고, '가상의 위치'로 먼저 테스트
            int nx = curX;
            int ny = curY;

            boolean isSafe = true; // 이동 가능한지 깃발

            for (int i = 0; i < n; i++) {
                // 방향에 따라 1칸씩 이동해보기
                if (op.equals("N")) nx--;      // 북: 행 감소
                else if (op.equals("S")) nx++; // 남: 행 증가
                else if (op.equals("W")) ny--; // 서: 열 감소
                else if (op.equals("E")) ny++; // 동: 열 증가

                // 체크 1: 공원 밖으로 나갔니?
                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    isSafe = false;
                    break;
                }
                // 체크 2: 장애물(X)이니?
                if (park[nx].charAt(ny) == 'X') {
                    isSafe = false;
                    break;
                }
            }

            // 중간에 아무 문제 없었을 때만! 실제 위치 업데이트
            if (isSafe) {
                curX = nx;
                curY = ny;
            }
        }

        return new int[]{curX, curY};
    }
}