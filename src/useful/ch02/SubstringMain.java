package useful.ch02;

public class SubstringMain {


    public static void main(String[] args) {
        // string의 인스턴스 메서드 .substring 무엇인지 확인하고 예제를 만들어보라

        // 문서의 설명: Returns a string that is a substring of this string.
        // 문자열을 매개변수1부터 매개변수2까지의 인덱스만큼 잘라 반환해주는 메서드이다.
        // 매개변수1개인 오버로딩 버전은 마지막까지 자른다.
        String oldText = "피카츄는 리자몽으로 진화한다.";
        String newText1 = oldText.substring(5, oldText.length());

        System.out.println("※※※※※ substring(int beginIndex, int endIndex) 버전 ※※※※※※");
        System.out.println("수정 전 텍스트::::::::::");
        System.out.println(oldText);

        System.out.println("수정 후 텍스트::::::::::");
        System.out.println(newText1);

        System.out.println("-------------------------------------");
        System.out.println("※※※※※ substring(int beginIndex) 버전 ※※※※※※");
        String newText2 = newText1.substring(6);

        System.out.println("수정 전 텍스트::::::::::");
        System.out.println(newText1);

        System.out.println("수정 후 텍스트::::::::::");
        System.out.println(newText2);


    }


}
