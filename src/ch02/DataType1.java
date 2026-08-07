package ch02;

/**
 * 데이터 타입
 *  변수의 종류와 크기를 지정하는 것
 *
 * Java의 데이터 타입 가장 큰 분류 2종
 *  1. 기본 자료형(Primitive Data Type)
 *   - 정수형, 문자형, 실수형, 논리형
 *  2. 참조 자료형(Reference Data Type)
 */
public class DataType1 {

    // 메인함수
    public static void main(String[] args) {
        // 정수형
        byte byteBox;       // 1 byte = 8 bits
        short shortBox;     // 2 bytes
        int intBox;         // 4 bytes (기본)
        long longBox;       // 8 bytes
        // 오버플로 예시
        //byteBox = -129;
        //shortBox = 32768

        // long타입 접미사
        longBox = 9L; // 접미사 L은 소문자 l 사용 가능

        // 실수형
        float floatBox;
        double doubleBox;

    } // end of main
} // end of class
