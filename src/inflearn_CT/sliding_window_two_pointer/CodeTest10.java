package inflearn_CT.sliding_window_two_pointer;

import java.util.HashMap;
import java.util.Scanner;

public class CodeTest10 {

    public  static int solution(String a, String b ){
        int answer = 0;
        HashMap<Character,Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for (char x : b.toCharArray()){
            bm.put(x, bm.getOrDefault(x,0)+1);
        }
        // slidingWindow
        int length = b.length()-1;
        for (int i = 0; i < length; i++) {
            am.put(a.charAt(i) , am.getOrDefault(a.charAt(i),0)+1);
        }
        int lt = 0;
        for (int rt = length; rt < a.length(); rt++) {
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt),0)+1);
            if(am.equals(bm)) answer++;
            am.put(a.charAt(lt) , am.getOrDefault(a.charAt(lt),0)-1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
            lt++;
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solution(a, b));
    }
}
