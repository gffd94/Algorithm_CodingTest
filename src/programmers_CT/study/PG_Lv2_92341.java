package programmers_CT.study;

import java.util.*;

public class PG_Lv2_92341 {
    public int[] solution(int[] fees, String[] records) {

        // 입출차 저장 Map
        Map<String, Integer> parkingMap = new HashMap<>();

        // 누적 차 시간 Map + 오름차순 작업 필요!
        Map<String, Integer> totalTimeMap = new TreeMap<>();

        for(String record : records) {
            String[] parts = record.split(" ");
            int parkingTime = timeToMin(parts[0]);
            String carNum = parts[1];
            String inNout = parts[2];

            // 입차
            if(inNout.equals("IN")){
                parkingMap.put(carNum, parkingTime);
            } else { // 출차
                // 사용 시간(출차 시간 - 입차 시간)
                int useTime = parkingTime - parkingMap.get(carNum);
                // 저장 (시간 중복 가능)
                totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + useTime);
                // 주자창 제거
                parkingMap.remove(carNum);
            }
        }

        // 출차 안한 차량 확인 및 TotalTime에 입력
        if(!parkingMap.isEmpty()){
            for(String reave : parkingMap.keySet()){
                int overTime = 1439 - parkingMap.get(reave);
                totalTimeMap.put(reave, totalTimeMap.getOrDefault(reave, 0) + overTime);
            }
        }

        int[] answer = new int[totalTimeMap.size()];
        int i = 0;

        int basicTime = fees[0];
        int basicFee = fees[1];
        int perTime = fees[2];
        int perFee = fees[3];

        // 차량번호 기준으로 정렬된 totalTimeMap을 요금 계산
        for(String carNum : totalTimeMap.keySet()){
            int totalTime = totalTimeMap.get(carNum);
            int totalFee = basicFee;

            if(totalTime > basicTime) {
                //Math.ceil
                totalFee += Math.ceil((double)(totalTime - basicTime) / perTime) * perFee;
            }

            answer[i++] = totalFee;
        }


        return answer;
    }

    public int timeToMin (String parkTime) {
        String[] parts = parkTime.split(":");
        int hourMin = Integer.parseInt(parts[0]) * 60;
        int min = Integer.parseInt(parts[1]);

        return hourMin + min;
    }
}
