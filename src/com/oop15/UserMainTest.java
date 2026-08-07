package com.oop15;

// 연관 관계 테스트
public class UserMainTest {

    public static void main(String[] args) {

        // 1. Todo1 객체와 User 객체는 서로 몰라도 각자 생성이 가능하다.
        Todo todo1 = new Todo("자바복습");
        User user1 = new User(1, "홍길동");

        // 2. 아직 연결되지 않은 상태 - todo1 필드는 null 상태
        user1.displayMyTask();
        System.out.println("-------------------------------------------------");

        // 3. 연관 관계 형성 - user1이 todo1의 주소값을 갖게 된다.
        user1.setTodo(todo1);
        user1.displayMyTask();

        // 4. todo1 참조 변수를 통해서 상태를 바꿔본다.
        todo1.setCompleted(true);

        // 5. user1을 통하여 조회해봐도 바뀐 상태가 보인다.
        // 즉, 복사본이 아니라 같은 객체 하나를 함께 가리키고 있다.
        user1.displayMyTask();


    }

}
