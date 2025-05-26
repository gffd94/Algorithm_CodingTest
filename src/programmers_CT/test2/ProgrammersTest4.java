package programmers_CT.test2;

import java.util.Arrays;
import java.util.Scanner;

public class ProgrammersTest4 {
/*이 코드는 프로그래머스 요격 시스템 문제로 알려진 “최소 요격 미사일 개수로 모든 타겟 요격하기” 문제에 대한 풀이입니다.
이 문제는 Greedy (탐욕법) + 구간 정렬 문제의 대표적인 예제
* */
  public static int solution (int[][] targets) {
      int answer = 0;
      double lastEnd = -1.0;

      Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

      for (int[] target : targets) {
          if (target[0] > lastEnd) {
              lastEnd = target[1] - 0.1;
              answer++;
          }
      }
      return answer;
  }

}
