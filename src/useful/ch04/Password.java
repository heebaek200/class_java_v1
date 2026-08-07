package useful.ch04;

public class Password {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            //System.out.println("비밀번호는 null일 수 없습니다.");
            throw new PasswordException("비밀번호는 null일 수 없습니다.");
        } else if (password.length() < 4) {
            //System.out.println("비밀번호는 4글자 이상이어야 합니다.");
            throw new PasswordException("비밀번호는 4글자 이상이어야 합니다.");
        }

        this.password = password;
    }

    public static void main(String[] args) {
        Password password1 = new Password();
        String[] testdatas = {null, "123", "1234"};

        for (String test: testdatas){

            try {
                System.out.println();
                System.out.println(test + " 데이터 입력 시:::::::");

                password1.setPassword(test);

                System.out.println("예외없이 정상 작동했습니다.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }
}

// 1. 사용자 정의 예외 클래스 설계
// 2. message를 받아서 출력할 수 있도록 설계
// 3. setPassword 에 오류 안내 메세지를 직접 만들어 둔 예외 클래스로 활용하시오.
// 4. 예외 클래스 이름은 PasswordException 으로 설계