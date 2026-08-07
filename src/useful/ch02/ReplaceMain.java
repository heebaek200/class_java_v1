package useful.ch02;

public class ReplaceMain {

    public static void main(String[] args) {
        // string의 인스턴스 메서드 .replace가 무엇인지 확인하고 예제를 만들어보라

        // 문서의 설명: Returns a string resulting from replacing all occurrences of oldChar in this string with newChar.
        // 문자열의 일부를 특정 문자열로 바꾸기 위한 메서드.
        // 매개변수 1번의 내용을 매개변수 2번의 내용으로 바꾼 새 문자열을 반환한다.
        // 원본은 바뀌지 않는다.
        // 예시)
        String oldText = "피카츄는 리자몽으로 진화한다.";
        String newText = oldText.replace("리자몽", "라이츄");

        System.out.println("※※※※※ replace(CharSequence target, CharSequence replacement) 버전 ※※※※※※");
        System.out.println("수정 전 텍스트::::::::::");
        System.out.println(oldText);

        System.out.println("수정 후 텍스트::::::::::");
        System.out.println(newText);

        System.out.println("-------------------------------------");
        // 두가지 메서드로 오버로딩되어 있는데, 앞서 사용한 것은 String의 부모클래스인 CharSequence인 버전이며, 매개변수가 char인 버전도 존재한다.
        String oldText2 = "피카츄는 리자몽으로 진화한다.";
        String newText2 = oldText.replace('카', ' ');

        System.out.println("※※※※※ replace(char oldChar, char newChar) 버전 ※※※※※※");
        System.out.println("수정 전 텍스트::::::::::");
        System.out.println(oldText2);

        System.out.println("수정 후 텍스트::::::::::");
        System.out.println(newText2);
    }

}
