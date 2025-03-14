import java.util.HashMap;

public class CodeTest13 {

    public static int[] solution(String s){
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> multiCheck = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if(multiCheck.containsKey(current)){
                answer[i] = i - multiCheck.get(current);

            }else {
                answer[i] = -1;
            }
            multiCheck.put(current, i);
        }

        return  answer;
    }

    public static void main(String[] args) {
        String input = "banana";
        int[] result = solution(input);

        for (int x : result){
            System.out.print(x + " ");
        }
    }
}
