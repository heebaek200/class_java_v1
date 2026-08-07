package useful.ch03;

public class StringTest2 {

    public static void main(String[] args) {

        String str1 = new String("Hello");
        String str2 = new String("World");

        System.out.println("str1 : " + str1);

        // String의 주소값 확인해보기
        System.out.println(System.identityHashCode(str1));

        // 문자열 값은 불변임을 확인
        //str1 = str1 + "world";
        str1 = str1.concat("world");
        System.out.println("str1 + world : " + str1);
        System.out.println(System.identityHashCode(str1));
    }

}
