package programmers_CT.test1;

public class ProgrammersTest3 {

    public static long solution(int r1, int r2){

        long count = 0;

        for (int x = 1; x <= r2; x++) {
            // 큰원 안에 포함되는 최대 y 값
            int maxY = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) x * x));
            // 작은원 안에에 포함되는 최소 y 값 (경계 제외)
            int minY = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) x * x));

            if (minY <= maxY) {
                count += (maxY - minY + 1); // 해당 x 좌표에서 가능한 y 개수 추가
            }
        }

        return count * 4; // 4분면 고려

    }

    public static void main(String[] args) {
        int r1 = 3, r2 = 4;
        System.out.println(solution(r1, r2)); // 예제 출력
    }
}
