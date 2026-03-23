import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        List<Long> sharks = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sharks.add(Long.parseLong(st.nextToken()));
        }
        // 정렬
        Collections.sort(sharks);

        //간의 저장소
        Stack<Long> stack = new Stack<>();
        int sharkidx = 0;
        
        for(int i = 0; i < K; i++){
            while(sharkidx < N && sharks.get(sharkidx) < T){
                stack.push(sharks.get(sharkidx));
                sharkidx++;
            }

            // 스택이 비어있으면 break
            if(stack.isEmpty()){
                break;
            }

            T += stack.pop();
        }

        System.out.println(T);
    }


}