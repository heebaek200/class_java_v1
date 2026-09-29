package oop_test.practice;

public class MusicService {

    private MusicDao dao;

    /**
     * 의존성 주입 : dao
     * @param dao
     */
    public MusicService(MusicDao dao) {
        this.dao = dao;
    }

    /**
     * title과 artist를 파라미터로 받아 Music 객체를 생성하고, dao의 insert 메서드로 전달
     * @param title
     * @param artist
     */
    public void addMusic(String title, String artist) {
        Music music = new Music(title, artist);
        dao.insert(music);
    }

    /**
     * dao의 findAll 메서드를 호출하여 목록을 받아온 뒤, 반복문을 사용하여 모든 곡의 제목과 아티스트를 출력
     */
    public void printPlaylist() {
        for (Music music : dao.findAll()) {
            System.out.println("제목 : %s | 아티스트 : %s".formatted(
                    music.getTitle(),
                    music.getArtist()
            ));
        }
    }


}
