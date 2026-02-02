package programmers_CT.testList;

import java.io.*;
import java.util.*;

public class MTestMain {

    static class Sizeinfo {
        String sizeName;
        int hMax, hMin; // 키
        int cMax, cMin; // 가슴
        int wMax, wMin; // 허리

        public Sizeinfo(String sizeName, int hMax, int hMin, int cMax, int cMin, int wMax, int wMin) {
            this.sizeName = sizeName;
            this.hMax = hMax;
            this.hMin = hMin;
            this.cMax = cMax;
            this.cMin = cMin;
            this.wMax = wMax;
            this.wMin = wMin;
        }

        // 내 몸안에 맞는 사이즈가 있는지
        public boolean isFit(int myH, int myC, int myW){
            return (myH >= hMin && myH <= hMax) &&
                (myC >= cMin && myC <= cMax) &&
                (myW >= wMin && myW <= wMax);
        }

        // 나보다 다 큰 경우 UP
        public boolean isUP(int myH, int myC, int myW){
            return myH > hMax && myC > cMax && myW > wMax;
        }
        // 나보다 다 작은 경우 DOWN
        public boolean isDOWN(int myH, int myC, int myW){
            return myH < hMin && myC < cMin && myW < wMin;
        }

        // (M, 185, 95, 100 ) -> 추천사이즈의 최대 값을 출력해야함.
        public String getOutputString() {
            return sizeName + ", " + hMax + ", " + cMax + ", " + wMax;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 파싱 꿀팁 : 콤마와 공백이 섞여있을 땐 split("[,\\s]+");
        String[] firstLine = br.readLine().split("[,\\s]+");
        int B = Integer.parseInt(firstLine[0]);
        int Q = Integer.parseInt(firstLine[1]);

        // 브랜드 저장소( 각 브랜드별 사이즈 정보들 담는 저장소)
        Map<String, List<Sizeinfo>> brandMap = new HashMap<>();

        // 브랜드 정보 입력
        for(int i = 0; i < B; i++) {
            String[] brandLine = br.readLine().split("[,\\s]+");
            String brandName = brandLine[0];
            int sizeCount = Integer.parseInt(brandLine[1]);

            List<Sizeinfo> sizeList = new ArrayList<>();
            for(int j = 0; j < sizeCount; j++) {
                String[] sizeLine = br.readLine().split("[,\\s]+");
                // sizeInfo에 정보를 넣고 그걸 List로 관리
                sizeList.add(new Sizeinfo(sizeLine[0],
                    Integer.parseInt(sizeLine[1]), Integer.parseInt(sizeLine[2]),
                    Integer.parseInt(sizeLine[3]), Integer.parseInt(sizeLine[4]),
                    Integer.parseInt(sizeLine[5]), Integer.parseInt(sizeLine[6])));
            }

            brandMap.put(brandName, sizeList);
        }


        // 손님 사이즈 추천 처리
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < Q; i++) {
            String[] require = br.readLine().split("[,\\s]+");
            String targetBrand = require[0];
            int myH = Integer.parseInt(require[1]);
            int myC = Integer.parseInt(require[2]);
            int myW = Integer.parseInt(require[3]);

            // 1. 원하는 브랜드가 없는 경우
            if(!brandMap.containsKey(targetBrand)) {
                sb.append("UNKNOWN").append("\n");
                continue;
            }

            // 나에게 맞는 옷 추천 확인 여부
            List<Sizeinfo> sizes = brandMap.get(targetBrand);
            // 정답 문자열 저장
            String resultString = null;
            // 확인하려는 변수들
            boolean isUP = true;
            boolean isDOWN = true;

            for(Sizeinfo size : sizes) {
                // 맞는 추천 사이즈가 있는가? ( 찾으면 즉시 종료 -> 가장 작은 사이즈 우선)
                if(size.isFit(myH, myC, myW)) {
                    resultString = size.getOutputString();
                    break;
                }
                // 추천 사이즈가 다 크다
                if(!size.isUP(myH, myC, myW)) isUP = false;
                // 추천 사이즈가 다 작다
                if(!size.isDOWN(myH, myC, myW)) isDOWN = false;
            }

            // 최종 출력
            if(resultString != null) {
                sb.append(resultString).append("\n");
            } else if (isUP) {
                sb.append("UP").append("\n");
            } else if (isDOWN) {
                sb.append("DOWN").append("\n");
            } else {
                sb.append("MIXMATCH").append("\n");
            }

        }

        System.out.print(sb);
    }
}
