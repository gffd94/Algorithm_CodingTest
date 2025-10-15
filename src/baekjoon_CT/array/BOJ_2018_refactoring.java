package baekjoon_CT.array;

import java.util.Scanner;

/*
* for문 vs while문
*
* 이 두개를 굳이 나눈 이유는 둘다 풀어봤는데 상황에 따라 다른 접근이 필요하다고 해서 정리하려고 나눔.
* for문
* 장점:
✅ rt의 범위가 명확함 (0부터 N-1까지 반드시 순회)
✅ 구조가 단순함 (rt는 자동 증가)
✅ 배열 전체를 확인해야 하는 문제에 적합
적합한 문제 유형:
연속 부분 수열의 합
슬라이딩 윈도우
배열의 모든 요소를 확인해야 하는 경우
*
* while문
* 장점:
✅ 더 유연한 제어 (lt, rt 모두 조건에 따라 이동)
✅ 조기 종료 가능 (특정 조건에서 break)
✅ 복잡한 조건을 다루기 쉬움
적합한 문제 유형:
정렬된 두 배열의 병합
특정 조건을 만족하면 조기 종료
lt와 rt가 독립적으로 움직여야 하는 경
*
* */

public class BOJ_2018_refactoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0 , lt = 1 , rt = 1, sum = 1;

        while (lt <= N){
            if(sum < N){
                rt++;
                sum += rt;
            } else if (sum > N) {
                sum -= lt;
                lt++;
            }else {
                count++;
                rt++;
                sum += rt;
            }
        }

        System.out.println( count);
    }
}
