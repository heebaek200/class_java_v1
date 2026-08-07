package useful.ch04;

/**
 * 사용자정의 예외 클래스 만들기
 */
public class DivideByZeroException extends RuntimeException {

    private String msg;

    public DivideByZeroException(String msg) {
        super(msg);     // RuntimeException의 메세지 출력을 커스텀
        this.msg = msg;
    }
}
