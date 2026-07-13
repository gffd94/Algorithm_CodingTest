        Soldier[] info = new Soldier[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            info[i] = new Soldier(x,y,p);
        }
        // 병사들 정보
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // 병사들의 관계정보
        ArrayList<Integer>[] relate = new ArrayList[n];

        // 병사들끼리 서로 소통이 가능한가
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if( i == j ) continue;
                

        for(int i = 0; i < n; i++) {
            relate[i] = new ArrayList<Integer>();
        }

        }
    }
            return dist <= sqrtP;
            long dx = this.x - other.x;
            long dy = this.y - other.y;

            long dist = (dx*dx) + (dy*dy);
            long sqrtP = (long) this.p * this.p;

            this.y = y;
            this.p = p;
        }

        public boolean distance(Soldier other) {
            // distance 계산 때문에 long타입 변환
        public Soldier(int x, int y, int p) {
            this.x = x;
        int x, y, p;
        
                if(info[i].distance(info[j])) {
                    relate[i].add(j);