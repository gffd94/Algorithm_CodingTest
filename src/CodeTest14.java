import java.util.Arrays;

public class CodeTest14 {

    public static int solution(int[] cards){
        int answer = 0;
        // 1~ 랜덤수 까지
        int[] newCards = new int[cards.length+1];
        // n그룹 개수
        int[] countGroup = new int[cards.length];

        for (int i = 1; i <= cards.length; i++) {
            newCards[i] = cards[i-1];
        }

        // 몇개의 그룹이 나올수 있는지 하나씩 탐색
        for (int i = 0; i < cards.length; i++) {
            int idx = i+1;
            int count = 0;
            while (newCards[idx]!=0){
                int current = newCards[idx];
                newCards[idx] = 0;
                System.out.println(current);
                idx = current;
                System.out.println(idx);
                count++;
                System.out.println(count);
            }
            countGroup[i] = count;
        }

        // 1 그룹만 나오는 경우
        if (countGroup.length == 1){
            return answer = 0;
        }else {
            Arrays.sort(countGroup);
            answer = countGroup[countGroup.length-1] * countGroup[countGroup.length-2];
        }

        return answer;
    }

    public static void main(String[] args) {
        // 이미 들어오는 수가 랜덤수
        int[] cards = {3,4,1,2};
        System.out.println(solution(cards));
    }
}
