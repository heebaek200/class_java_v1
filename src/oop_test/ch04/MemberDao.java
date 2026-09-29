package oop_test.ch04;

import java.util.ArrayList;
import java.util.List;

public class MemberDao {

    private List<Member> store = new ArrayList<>();

    public void insert (Member member) {
        store.add(member);

        System.out.println("[%s] 회원 정보가 DB에 저장되었습니다.".formatted(
                member.getName()
        ));
    }

    public List<Member> findAll() {
        return store;
    }

}
