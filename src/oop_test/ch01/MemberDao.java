package oop_test.ch01;

public class MemberDao {

    public void insert (Member member) {
        System.out.println("[%s] 회원 정보가 DB에 저장되었습니다.".formatted(
                member.getName()
        ));
    }

}
