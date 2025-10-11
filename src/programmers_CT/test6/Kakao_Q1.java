package programmers_CT.test6;

import java.util.*;

public class Kakao_Q1 {
    public int solution(String message, int[][] spoilerRanges) {
        // 1. 메시지에서 단어와 위치 추출
        List<Word> allWords = extractWords(message);

        // 2. 스포 방지 단어와 중요 단어 후보 판별을 위한 전처리
        Set<String> spoilerWords = new HashSet<>(); // 스포 방지 단어 집합
        Map<String, Boolean> allInstancesInSpoiler = new HashMap<>(); // 단어의 모든 인스턴스가 스포일러에 걸리는지

        // 스포 방지 단어 식별 (룰 1)
        for (Word word : allWords) {
            for (int[] range : spoilerRanges) {
                if (isOverlap(word.start, word.end, range[0], range[1])) {
                    spoilerWords.add(word.text);
                    break;
                }
            }
        }

        // 단어별 모든 인스턴스가 스포일러에 걸리는지 확인 (룰 2)
        for (String uniqueWord : new HashSet<>(allWords.stream().map(w -> w.text).toList())) {
            boolean allCovered = true;
            for (Word word : allWords) {
                if (word.text.equals(uniqueWord)) {
                    boolean isCovered = false;
                    for (int[] range : spoilerRanges) {
                        if (isOverlap(word.start, word.end, range[0], range[1])) {
                            isCovered = true;
                            break;
                        }
                    }
                    if (!isCovered) { // 한 인스턴스라도 스포일러에 안 걸리면
                        allCovered = false;
                        break;
                    }
                }
            }
            allInstancesInSpoiler.put(uniqueWord, allCovered);
        }

        // 3. 스포 방지 구간을 순서대로 클릭하며 중요 단어 카운트
        Set<String> revealedWords = new HashSet<>(); // 이미 공개된 단어
        int importantWordCount = 0;

        // 왼쪽->오른쪽 순서로 클릭하기 위해 정렬
        Arrays.sort(spoilerRanges, Comparator.comparingInt(a -> a[0]));

        for (int[] range : spoilerRanges) {
            // 현재 클릭으로 공개되는 단어들 찾기
            List<Word> revealedInThisClick = new ArrayList<>();
            for (Word word : allWords) {
                if (isOverlap(word.start, word.end, range[0], range[1])) {
                    revealedInThisClick.add(word);
                }
            }

            // 왼쪽부터 순서대로 처리 (룰 4)
            revealedInThisClick.sort(Comparator.comparingInt(a -> a.start));

            for (Word word : revealedInThisClick) {
                // 중요 단어 조건 확인
                if (spoilerWords.contains(word.text) && // 룰 1: 스포 방지 단어인가?
                    allInstancesInSpoiler.get(word.text) && // 룰 2: 모든 인스턴스가 스포일러에 걸리는가?
                    !revealedWords.contains(word.text)) { // 룰 3: 이전에 공개된 적 없는가?

                    importantWordCount++;
                    revealedWords.add(word.text);
                }
            }
        }

        return importantWordCount;
    }

    // 단어 추출 메서드
    private List<Word> extractWords(String message) {
        List<Word> words = new ArrayList<>();
        int start = -1;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    words.add(new Word(message.substring(start, i), start, i - 1));
                    start = -1;
                }
            }
        }

        if (start != -1) {
            words.add(new Word(message.substring(start), start, message.length() - 1));
        }

        return words;
    }

    // 두 구간이 겹치는지 확인하는 메서드
    private boolean isOverlap(int start1, int end1, int start2, int end2) {
        return end1 >= start2 && start1 <= end2;
    }

    // 단어 클래스
    static class Word {
        String text;
        int start;
        int end;

        Word(String text, int start, int end) {
            this.text = text;
            this.start = start;
            this.end = end;
        }
    }

    // 테스트
    public static void main(String[] args) {
        Kakao_Q1 solution = new Kakao_Q1();

        // 예제 1
        String message1 = "here is muzi here is a secret message";
        int[][] spoilerRanges1 = {{0, 3}, {23, 28}};
        System.out.println("예제 1 결과: " + solution.solution(message1, spoilerRanges1)); // 1

        // 예제 2
        String message2 = "my phone number is 01012345678 and may i have your phone number";
        int[][] spoilerRanges2 = {{5, 5}, {25, 28}, {34, 40}, {53, 59}};
        System.out.println("예제 2 결과: " + solution.solution(message2, spoilerRanges2)); // 4
    }
}
