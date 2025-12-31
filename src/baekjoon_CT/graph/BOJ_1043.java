package baekjoon_CT.graph;

import java.io.*;
import java.util.*;

public class BOJ_1043 {
    static int[] parent; // 유니온 파인드용 부모 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        // 1. 진실을 아는 사람 저장
        stk = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(stk.nextToken());
        int[] true_man = new int[k];
        for (int i = 0; i < k; i++) {
            true_man[i] = Integer.parseInt(stk.nextToken());
        }

        // 2. 파티 정보 저장
        ArrayList<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            int party_size = Integer.parseInt(stk.nextToken());
            for (int j = 0; j < party_size; j++) {
                party[i].add(Integer.parseInt(stk.nextToken()));
            }
        }

        // 3. 유니온 파인드 초기화 (자기가 자기의 부모)
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 4. 파티별로 사람들을 하나의 집합으로 묶기 (Union)
        // [작성자님이 멈춘 부분 해결!]
        for (int i = 0; i < m; i++) {
            if (party[i].size() > 0) { // 파티원이 있을 때만
                int first_man = party[i].get(0); // 파티의 첫 번째 사람을 기준으로
                for (int j = 1; j < party[i].size(); j++) {
                    // 첫 번째 사람과 나머지 사람들을 모두 같은 집합으로 합침
                    union(first_man, party[i].get(j));
                }
            }
        }

        // 5. 거짓말 할 수 있는 파티 개수 세기
        int count = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            if (party[i].size() > 0) {
                int party_root = find(party[i].get(0)); // 이 파티의 대표자(Root) 확인

                // 진실을 아는 사람들과 같은 그룹인지 확인
                for (int t_man : true_man) {
                    if (party_root == find(t_man)) {
                        // 파티의 대표자와 진실맨의 대표자가 같다면? -> 연결된 것!
                        canLie = false;
                        break;
                    }
                }
            }
            if (canLie) count++;
        }

        System.out.println(count);
    }

    // [핵심 1] Find: 내 집합의 대표자(Root) 찾기 + 경로 압축
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축 (바로 부모를 대표자로 갱신)
    }

    // [핵심 2] Union: 두 사람을 같은 집합으로 합치기
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA; // B의 대표를 A로 변경
        }
    }
}
