package programmers_CT.test4;

public class ProgrammersTest2_1 {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long totalSum = 0;
        int[] arr = new int[n * 2];

        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i + n] = queue2[i];
            totalSum += queue1[i] + queue2[i];
        }

        // 합이 홀수면 두 큐를 같게 만들 수 없음
        if (totalSum % 2 != 0) return -1;

        long target = totalSum / 2;
        int left = 0, right = 0;
        long sum = arr[0];
        int minOps = Integer.MAX_VALUE;

        while (left < 2 * n && right < 2 * n) {
            if (sum == target) {
                // 이동 횟수는 원래 큐 기준으로 변환
                int moves = getMoveCount(left, right, n);
                minOps = Math.min(minOps, moves);
                sum -= arr[left++];
            } else if (sum < target) {
                if (++right < 2 * n) {
                    sum += arr[right];
                }
            } else {
                sum -= arr[left++];
            }
        }

        return (minOps == Integer.MAX_VALUE) ? -1 : minOps;
    }

    // 슬라이딩 윈도우 구간을 이용해 이동 횟수 계산
    private int getMoveCount(int left, int right, int n) {
        if (right < n) {
            return left + right + 1;
        } else {
            return left + (right - n + 1);
        }
    }
}
