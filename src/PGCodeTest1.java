public class PGCodeTest1 {

    static int[] solution(long n){
        String s = Long.toString(n);
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            answer[i] = s.charAt(s.length()-1-i) - '0';
        }

        return answer;
    }

    public static void main(String[] args) {
        long n = 12345;
        for(int x : solution(n)){
            System.out.print(x+" ");
        }
    }
}
