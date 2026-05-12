        // 꼭짓점 좌표 저장
        int[] xs = new int[n];
        int[] ys = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[i] = Integer.parseInt(st.nextToken());
            ys[i] = Integer.parseInt(st.nextToken());
        }

        // 차분 배열 2개 (h, v 따로)
        int[] diffY = new int[SIZE];   // 수직선분의 y구간
        int[] diffX = new int[SIZE];   // 수평선분의 x구간

        // 변 추출 + 차분 기록
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;        // 다각형 닫힘
            int x1 = xs[i], y1 = ys[i];
            int x2 = xs[next], y2 = ys[next];

            if (x1 == x2) {
                // 수직선분 → y구간
                int lo = Math.min(y1, y2);
                int hi = Math.max(y1, y2);
                diffY[lo + OFFSET] += 1;
                diffY[hi + OFFSET] -= 1;
            } else {
                // 수평선분 → x구간
                int lo = Math.min(x1, x2);
                int hi = Math.max(x1, x2);
                diffX[lo + OFFSET] += 1;
                diffX[hi + OFFSET] -= 1;
            }
        }

        // h: y축 누적합의 최댓값
        int h = 0, cur = 0;
        for (int i = 0; i < SIZE; i++) {
            cur += diffY[i];
            h = Math.max(h, cur);
        }

        // v: x축 누적합의 최댓값
        int v = 0;
        cur = 0;
        for (int i = 0; i < SIZE; i++) {
            cur += diffX[i];
            v = Math.max(v, cur);
        }

        System.out.println(Math.max(h, v));