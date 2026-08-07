package ch08;

public class ContinueTest2 {

    public static void main(String[] args) {
        // 1층 ~ 15층 엘리베이터가 올라간다. 단, 4층은 세지않고 건너뛴다.

        for (int i = 1 ; i <= 15 ; i++) {
            if (i == 4) {
                // 무섭!
                continue;
            }

            System.out.println(i + "층입니다!");
        }

    }

}
