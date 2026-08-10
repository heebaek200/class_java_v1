package practice.programmers.code2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    // 문제 시작: 17시 54분

    // 카카오톡 스포 방지 기능

    // 각 단어는 공백 구분. 알파벳 소문자와 숫자로만 구성된 연속된 문자열임.
    // 인덱스 중 하나 이상이 스포 방지 구간에 포함되면, 스포일러 방지 단어
    // 한 단어가 여러개의 스포 방지 구간에 걸쳐 있을 수 있으며, 한 구간에 여러 단어가 포함될 수 있음.

    // 중요한 단어의 구성요건
    // 1. 스포 방지 단어여야 함.
    // 2. 스포 방지 구간이 아닌 구간에 등장하지 않아야 함.
    // 3. 공개된 스포 방지 단어와 중복되지 않아야 함.
    // 4. 여러 단어가 동시 공개된 경우, 왼쪽부터 하나씩 중요한 단어인지 판단한다.

    // INPUT
    // message: 입력 문자열
    //      1 <= message.length <= 20000
    //      알파벳 소문자, 숫자, 공백으로 이루어져 있음. 공백은 연속해서 등장하지 않음.
    // spoiler_ranges: 스포 방지가 적용된 구간을 나타내는 2차원 정수 배열
    //      1 <= spoiler_ranges.length <= 1000
    //      각 요소는 [start, end]
    //          start, end는 문자 인덱스이며 구간에 포함된다.
    //                 0 <= start <= end <= message.length
    //                 서로 겹치지 않으며 오름차순 정렬되어 있다.

    // OUTPUT
    // 스포 방지 단어 중 중요한 단어의 수를 return 하시오.

    // 예시 1)
    //  "here is muzi here is a secret message", [[0, 3], [23, 28]]
    //
    //  "---- is muzi here is a ------ message"
    //    1. 첫 here가 공개되었으나, 스포 방지 구간이 아닌 곳에서 등장했으므로 중요한 단어가 아니다.
    //    2. secret는 중요한 단어다.
    //   따라서 OUTPUT은 1이다.

    // 예시 2)
    //  "my phone number is 01012345678 and may i have your phone number", [[5, 5], [25, 28], [34, 40], [53, 59]]
    //
    //  "my ph-ne number is 010123----8 and-------habe your ph-------ber"
    //    1. o가 공개되었고 단어는 phone이다. (1) 스포 방지 구간이 아닌 곳에서 등장하지 않는다. (2) 이전 스포 방지 단어와 중복되지 않는다. -> 따라서 중요한 단어다.
    //    2. 01012345678 중요한 단어.
    //    3. may, i가 공개되었고 둘 다 중요한 단어.
    //    4. phone은 중복이므로 아니고, number는 스포 방지 구간이 아닌 곳에도 있으므로 둘 다 중요한 단어 아님.
    //   따라서 OUTPUT은 4이다. phone, 01012345678, may, i

    // 문제 이해: ~18시 15분

    // 아래는 사고
    //  원본 message를 ' ' 스페이스바로 split하여 HashMap<String, int> words에 담음.
    //  1. spoiler_ranges를 루프하여 words 내의 스포일러 처리되지 않은 단어를 1:일반단어로 분류함.
    //  2. words를 루프하여 스포일러 처리된 단어는 2:중요단어로 분류함. 이 때 이미 1로 분류되어 있다면 패스함.
    //  중요단어를 카운터하여 return.

    // 1차 사고: ~18시 21분

    int answer = 0;
    public int solution(String message, int[][] spoiler_ranges) {

        final int UNKNOWN = 0;
        final int NORMAL = 1;
        final int IMPORTANT = 2;

        // 최초 자름
        String[] originWords = message.split(" ");

        // words 분류
        HashMap<String, Integer> words = new HashMap<>();
        for (String ori : originWords) {
            if (ori.equals("") || ori.equals(" ")) {

            } else {
                words.put(ori, UNKNOWN);
            }
        }

        // 실제 스포일러 단어 범위 확장, 스포일러 단어 수집
        LinkedList<String> fullwords = new LinkedList<>();
        for (int[] range : spoiler_ranges) {
            String[] fulls = proc1(message, range);
            for (String full : fulls) {
                fullwords.add(full);
            }
        }

        // 일반 단어 선별
        int start = 0;
        int end = 0;
        for (int[] range : spoiler_ranges) {
            end = range[0];

            if (start < end) {
                String[] fulls = proc2(message, new int[]{start, end});

                for (String normalWord : fulls) {
                    words.put(normalWord, NORMAL);
                }
            }

            start = range[1];
        }
        // 마지막 단어까지
        if (start < message.length()) {
            String[] fulls = proc2(message, new int[]{start, message.length()-1});

            for (String normalWord : fulls) {
                words.put(normalWord, NORMAL);
            }
        }

        words.forEach((key, value) -> {
            if (value == UNKNOWN) {
                value = IMPORTANT;
                answer++;
            }
        });

        return answer;
    }

    // 비스포일러 사이 선별
    public String[] proc2(String message, int[] range) {
        int start = range[0];
        int end = range[1];

        String fullSpace = message.substring(start, end+1);

        // 자름
        String[] fullwords = fullSpace.split(" ");

        return fullwords;
    }

    // 스포일러 s-e 사이에 등장하는 단어들 선별 (앞 뒤 공백까지)
    public String[] proc1(String message, int[] range) {
        int start = range[0];
        int end = range[1];

        // start 내려가보기
        while (true) {
            String t = message.substring(start, start + 1);

            if (start <= 0 || t.equals(" ")) {
                break;
            } else {
                start--;
            }
        }

        // end 올라가보기
        while (true) {
            String t = message.substring(end, end + 1);

            if (end + 1 >= message.length() || t.equals(" ")) {
                break;
            } else {
                end++;
            }
        }

        String fullSpace = message.substring(start, end + 1);

        // 테스트해보기 :
        // 0까지 내려가보기, 끝까지 올라가보기


        // 자름
        String[] fullwords = fullSpace.split(" ");

        // range 갱신
        range[0] = start;
        range[1] = end;

        return fullwords;
    }

    // 코드 완성 19:12
    // 특기사항: 1번의 디버깅 없이 실행 -> 채점까지 한 방에 성공함(이게 되네)


//    public static void main(String[] args) {
//        //System.out.println("here ".substring(3,4));
//
//        Solution solution = new Solution();
//        int val = solution.solution("my phone number is 01012345678 and may i have your phone number", new int[][]
//                {{5, 5}, {25, 28}, {34, 40}, {53, 59}}
//                //{{0, 3}, {23, 28}}
//        );
//        System.out.println(val);
//    }
}
