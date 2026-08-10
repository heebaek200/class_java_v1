package useful.ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ChatRoomStore {


    private static List<String> users = new Vector<>();
    //private static List<String> users = new ArrayList<>();


    public static void main(String[] args) throws InterruptedException {


        System.out.println("===== 채팅방 접속자 시뮬레이션 =====");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("철수");
                System.out.println("[접속] 철수 | 현재 : " + users.size() + "명");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("영희");
                System.out.println("[접속] 영희 | 현재 : " + users.size() + "명");
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                users.add("민준");
                System.out.println("[접속] 민준 | 현재 : " + users.size() + "명");
            }
        });

        t1.start();
        t2.start();
        t3.start();

        // 스레드가 종료할 때까지 기다리기
        t1.join();
        t2.join();
        t3.join();

        System.out.println("최종 접속자 : " + users);

        users.remove("영희");     // 영희 퇴장

        // 브로드캐스트 : 현재 접속한 사용자 모두에게 메세지 보내기
        for (String u : users) {
            System.out.println("-> " + u + "에게 전송 : 안녕하세요");
        }

        String[] users = new String[100];
        int count = 0;
        users[count++] = "철수";
        users[count++] = "영희";
        users[count++] = "민준";

        // Arrays가 제공하는 .asList() 메서드를 사용하는 방법이 있습니다. 다만 null인 요소도 집어넣어서 출제요구에 맞지 않을 것 같네요.
        ArrayList<String> usersArrayList = new ArrayList<>(Arrays.asList(users));
        System.out.println(usersArrayList);

        // 따라서 아래와 같이 루프를 돌리는 방법이 정답일 것 같습니다.
        ArrayList<String> usersArrayList2 = new ArrayList<>();
        for (String item : users) {
            if (item != null) usersArrayList2.add(item);
        }
        System.out.println(usersArrayList2);

    }

}

