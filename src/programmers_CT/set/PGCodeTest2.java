package programmers_CT.set;


import java.util.HashSet;
import java.util.Set;

public class PGCodeTest2 {

    public static boolean solution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if(x < 1 || x > 45) return false;
             set.add(x);
        }
        return set.size() == arr.length;
    }



    // 중복값 확인하는 정석 풀이
//    public static boolean solution(int[] arr) {
//
//        boolean[] check = new boolean[46];
//        for (int i : arr) {
//            if(i < 1 || i > 45) return false;
//            if(check[i]) return false;
//            check[i] = true;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        int[] arr = {3, 19, 34, 39, 39, 20};
        System.out.println(solution(arr));
    }
}
