package design.single;

// 과제: SingleTon 클래스를 보고 싱글톤 패턴의 UserService을 만들어보세요
public class UserService {

    private static UserService instance;

    private UserService() {}

    private static synchronized UserService getInstance() {
        return instance = (instance == null) ? new UserService() : instance;
    }

}
