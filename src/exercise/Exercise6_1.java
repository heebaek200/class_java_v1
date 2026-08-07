package exercise;

public class Exercise6_1 {
    public static void main(String[] args) {
        // 이중 for를 사용하여 아래를 출력하시오
        // 0 1 2
        // 0 1 2
        // 0 1 2
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j <= 2 ; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // 이중 for를 사용하여 아래를 출력하시오
        // *
        // ***
        // *****
        // *******
        System.out.println("-------------------------");
        int starLen = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < starLen; j++) {
                System.out.print('*');
            }
            System.out.println();

            starLen += 2;
        }

        // 이중 for를 사용하여 아래를 출력하시오
        // *******
        // *****
        // ***
        // *
        System.out.println("-------------------------");
        for (int i = 0 ; i < 4 ; i++) {
            starLen -= 2;
            for (int j = 0 ; j < starLen ; j++) {
                System.out.print('*');
            }
            System.out.println();
        }



    }
}
