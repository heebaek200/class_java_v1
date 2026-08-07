package practice.programmers.code1;
class Solution {

    public static void main(String[] args) {
        // tdata
        //new Solution().solution(new int[][]{{2, 1, 2}, {5, 1, 1}});
//        new Solution().solution(new int[][]{{3, 3, 3}, {5, 4, 2}, {2, 1, 2}});
        new Solution().solution(new int[][]{{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}});
    }

    public int solution(int[][] signals) {
        //////System.out.println("-------");

        int answer = -1;

        int MAX_BOX = 10000000;

        char[][] box = new char[signals.length][];

        for (int i = 0 ; i < signals.length ; i++) {
            // 초기화 box
            box[i] = new char[MAX_BOX+1];

            int boxIndex = 1;

            while (true) {
                for (int j = 0; j < signals[i].length; j++) {
                    //System.out.print(signals[i][j] + " ");

                    for (int k = 0; k < signals[i][j]; k++) {
                        char char1 = 'Z';
                        switch (j) {
                            case 0:
                                char1 = 'G';
                                break;
                            case 1:
                                char1 = 'Y';
                                break;
                            case 2:
                                char1 = 'R';
                                break;
                        }
                        box[i][boxIndex] = char1;
                        boxIndex++;
                        if (boxIndex > MAX_BOX) break;
                    }

                    if (boxIndex > MAX_BOX) break;
                }

                if (boxIndex > MAX_BOX) break;
            }

            //////System.out.println();
        }


        //////System.out.println("-------");

        for (int p = 1 ; p < MAX_BOX+1 ; p++) {
            int checker = 0;
            for (int q = 0 ; q < box.length ; q++) {
                //System.out.print(box[q][p] + " ");

                if (box[q][p] == 'Y') {
                    checker++;
                }
            }

            if (checker == signals.length) {
                answer = p;
                break;
            }

            //////System.out.println();
        }

        System.out.println(answer);
        return answer;
    }
}