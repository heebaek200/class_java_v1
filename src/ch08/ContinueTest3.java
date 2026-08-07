package ch08;

import java.util.ArrayList;
import java.util.Arrays;

public class ContinueTest3 {

    public static void main(String[] args) {
        // 369 게임 1~30까지 세되, 3, 6, 9가 포함된 숫자는 "짝!"이라고 외친다.
        int number = 60;

        for (int i = 1 ; i <= number ; i++) {
            boolean flg = false;    // 박수쳤음 깃발

            int temp = i;
            while (temp > 0) {  // 각 자리 3 6 9 판별
                int v = temp % 10;
                if (v == 3 || v == 7 || v == 9) {   // 여기서 갑자기 3 7 9 게임으로
                    System.out.print("짝!");     // 3, 6, 9에 박수치고
                    flg = true;
                }
                temp /= 10;
            }

            if (flg) { // 박수 쳤으면 숫자 안세고 넘기기
                System.out.println();
                continue;
            }

            System.out.println(i + "!");
        }


    }

}
