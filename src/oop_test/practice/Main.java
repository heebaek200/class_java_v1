package oop_test.practice;

public class Main {
    public static void main(String[] args) {
        //1. MusicDao 객체를 생성하세요.
        MusicDao musicDao = new MusicDao();

        //2. MusicService 객체를 생성하며 앞서 만든 MusicDao 객체를 생성자 파라미터로 주입하세요.
        MusicService musicService = new MusicService(musicDao);

        //3. addMusic 메서드를 호출하여 서로 다른 곡 3개를 추가하세요.
        musicService.addMusic("피카츄 라이츄", "미상");
        musicService.addMusic("잡고말거야", "누구더라");
        musicService.addMusic("포켓몬 포에버", "그런노래");

        //4. printPlaylist 메서드를 호출하여 플레이리스트가 정상적으로 출력되는지 확인하세요.
        musicService.printPlaylist();

    }
}
