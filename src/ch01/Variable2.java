package ch01;

/**
 * 변수란? 데이터를 저장하고 참조하기 위해 이름을 붙인 메모리 공간
 *
 *  1. 선언
 *  2. 대입
 *  3. 접근
 */
public class Variable2 {

    // 메인 함수 (실행의 시작점)
    public static void main(String[] args) {

        // 변수의 규칙
        // 1. 대소문자를 구분하고, 길이 제한 없음
        int age = 10; // 선언과 동시에 초기화
        // int age = 10; <- 같은 중괄호 안에서 이거 안됨
        int aGe = 10;
        int aGE = 10;

        // 2. 자바의 예약어(reserved keyword)는 사용 불가
        // int, double, for, while, List 등

        // 3. 특수문자는 _와 $만 허용
        int _count;
        // int *count;
        int $_tel;
        int tel_count_$age;
    } // end of main


} // end of class
