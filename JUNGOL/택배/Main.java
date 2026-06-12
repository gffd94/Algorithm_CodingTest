
        for(int[] adr : address) {

                                return arrive; });

            pq.add(adr);
        }
        while(!pq.isEmpty()) {
        // 1부터 n까지 마을 배송
        int[] box = new int[n+1];
                                }
            int[] cur = pq.poll();
        int answer = 0;
        

        
        }

        System.out.print(answer);
                                    return o1[0] - o2[0];
                                if(arrive == 0) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> {
                                int arrive = o1[1] - o2[1];


        // 도착지기준으로 정렬 하되, 같다면 출발지가 빠른 순으로

            int start = cur[0];
            int end = cur[1];
            int capacity = cur[2];

            int maxBox = 0;
            for(int i = start; i < end; i++) {
                maxBox = Math.max(maxBox, box[i]);
            }

            int weight = Math.min(capacity, c - maxBox);
            for(int i = start; i < end; i++){
                box[i] += weight;
            }

            answer += weight;
    }
}