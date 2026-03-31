import java.util.*;
import java.io.*;

public class Main {
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int[] answer = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){

            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }

            stack.push(i);

        }

        while(!stack.isEmpty()){
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int x : answer){
            sb.append(x+" ");
        }
       
        System.out.println(sb.toString());
        
    }

    


}