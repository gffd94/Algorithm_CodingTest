package programmers_CT.study;

public class PG_Lv2_43165 {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);


        return answer;

    }


    void dfs(int[] numbers, int target, int index, int current){
        if(index == numbers.length){
            if(current == target)answer++;
            return;

        }
        // +증가
        dfs(numbers, target, index + 1, current + numbers[index]);
        // -감소
        dfs(numbers, target, index + 1, current - numbers[index]);
    }


}
