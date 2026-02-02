import java.util.*;
import java.io.*;

// 이 페이지는 손에 익을 때 까지 매일 하루에 3번씩 지웠다 썻다 할 것!
// 절대 보고 쓰지 않기.
public class CodingTestCheatSheet  {
    // 1. 클래스 활용 [복잡한 데이터 묶기]
    public static class Product implements Comparable<Product>{
        String name;
        int price;
        int reviewCount;

        // 생성자
        public Product(String name, int price, int reviewCount){
            this.name = name;
            this.price = price;
            this.reviewCount = reviewCount;
        }

        // 정렬 Comparable 구현
        // 음수 리턴 내가 앞으로 감. 양수 리턴 내가 뒤로 감.
        @Override
        public int compareTo(Product o) {
            if(this.price == o.price){
                return o.reviewCount - this.reviewCount; // 가격이 같다면 리뷰가 많은 순(내림차순)
            }

            return this.price - o.price; // 가격 싼 순(오름차순)
        }
    }

    public static void main(String[] args) throws IOException {

        // 2.문자열 파싱
        String rawData = "NIKE, 1880000,  500";

        // 2-1 기본 자르기
        String[] parts = rawData.split(",");
        // [,]+ : 콤마가 하나 이상 있거나
        // \\s+ : 공백이 하나 이상 있으면 자른다.
        String[] clean = rawData.split("[,\\s]+");

        int price = Integer.parseInt(parts[1]);

        if(clean[0].equals("NIKE")) {}

        // 2-2.문자열 뒤집기 & 수정
        StringBuilder sb = new StringBuilder();
        sb.append("KAKAO");
        sb.reverse(); // 뒤집기
        System.out.println(sb.toString());

        // 2-3. 특정 문자제거
        String trash = "[1,2,3]";
        String numOnly = trash.replaceAll("[\\[\\]]",""); // 대괄호 제거


        // 3. [List & Array] 데이터 담고 정렬하기
        // 3-1. 리스트 선언
        List<Product> list = new ArrayList<>();
        list.add(new Product("ADIDAS", 200000, 300));
        list.add(new Product("ASICS", 140000, 4000));

        // 3-2. 삭제
        //list.remove(1); // 인덱스 1번 삭제
        //list.remove(Integer.valueOf(1)); // 숫자1 이라는 객체를 찾아서 삭제

        // 3-3. 정렬 (Collections.sort())
        // 방법 A : 클래스에 compareTo()가 구현 되있는 경우
        Collections.sort(list);

        // 방법 B : 내 맘대로 정렬(람다식)
        // (p1, p2) -> p1(나) - p2(쟤) : 오름차순
        // (p1, p2) -> p2(쟤) - p1(나) : 내림차순
        list.sort((p1, p2) -> p2.reviewCount - p1.reviewCount); // 내림차순 ( 리뮤 많은 순)

        // 3-4. 배열
        String[] arr = {"A", "B", "C"};
        List<String> strList = new ArrayList<>(Arrays.asList(arr));
        // 배열 -> 리스트로 전환

        // 3-5. 2차원 배열 정렬 (탐욕법 / 정렬 문제)
        int[][] ranges = {{10, 2}, {5, 1}, {10, 5}};
        Arrays.sort(ranges, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1]; // 앞자리 같으면 뒷자리 오름차순
            return o1[0] - o2[0]; // 앞자리 오름차순
        });

        // 4. [Map & Set] 검색 속도 빠름
        // 4-1 Map 선언
        Map<String, List<Product>> map = new HashMap<>();

        // 4-2 데이터 넣기
        String brand = "PUMA";
        if(!map.containsKey(brand)){
            map.put(brand, new ArrayList<>());
        }
        map.get(brand).add(new Product("PUMA", 130000, 20));

        // getOrDefault 사용
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("APPLE", countMap.getOrDefault("APPLE", 0)+ 1);

        // 4-3 순회
        for(String key : map.keySet()) {
            List<Product> products = map.get(key);
        }

        // 4-4 중복제거
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1); // 무시
        if(set.contains(1)) {}

        // 5. [Stack & Queue] 순서대로 처리
        // (BFS, 선착순) -> Queue
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.peek();
        q.poll();

        // (괄호 짝맞추기, 되돌리기) -> Stack
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.peek();
        s.pop();

        // 6. [Math & Util]
        int a = -5, b = 10;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int abs = Math.abs(a); // 거리 구할 때 (절대 값)
        int sqrt = (int) Math.sqrt(25); // 소수 판별할 때 (제곱 근)

        // 7. [PriorityQueue] 우선순위 큐 -> 최솟값/ 최댓값 자동 정렬
        // 가장 작은 놈만 계속 꺼내야 할 때, 다익스트라(최단거리)

        // 7-1. 오름차순 (기본 : 작은 숫자가 먼저 나옴)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(100);
        minHeap.offer(10);
        minHeap.offer(50);
        int minq = minHeap.poll(); // 10 나옴 자동 정렬

        // 7-2. 내림차순 (큰 숫자가 먼저나옴)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 7-3. 커스텀 객체 정렬 ( 에시: 가격 싼 순서대로)
        PriorityQueue<Product> pq = new PriorityQueue<>();
        // Product 클래스에 compareTo() 가 구현 되어있어야 함.

        // 8. [Gird 탐색] -> 2차원 배열 이동 (BFS/DFS 필수)
        // 용도 : 지도, 미로찾기, 로봇 청소기 등 시뮬레이션
        // 문제에서 "상하좌우로 이동"나오면 무조건!
        int[][] gridMap = new int[10][10];
        int r = 0, c = 0; // 현재 위치

        // 상하좌우 ( 문제 조건에 맞게 설정)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < 4; i++){
            int nr = r + dr[i]; // 다음 행
            int nc = c + dc[i]; // 다음 열

            // 필수!
            if( nr < 0 || nr >= 10 || nc < 0 || nc >= 10){
                continue;
            }
        }

        // 9. [이진 탐색] 업다운 게임 (Binary Search)
        // 숫자가 10억개 쯤 되는데 그 중 하나를 찾아야 할 때 (시간 초과 방지)
        // 조건 : 정렬된 상태

        int[] numbers = {1, 3, 4, 6, 2,  7, 9, 11, 15};
        Arrays.sort(numbers);

        int target = 7;
        int start = 0;
        int end  = numbers.length - 1;
        boolean found = false;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(numbers[mid] == target){
                found = true;
                break;
            }else if(numbers[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

     }
}
