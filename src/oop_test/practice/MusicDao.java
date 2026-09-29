package oop_test.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터 처리 객체 MusicDao
 */
public class MusicDao {

    private List<Music> playlist = new ArrayList<>();

    /**
     * 파라미터로 받은 Music 객체를 playlist에 추가하고, "[곡명] 곡이 플레이리스트에 추가되었습니다." 라고 출력.
     * @param music
     */
    public void insert(Music music) {
        playlist.add(music);

        System.out.println("[%s] 곡이 플레이리스트에 추가되었습니다.".formatted(
                music.getTitle()
        ));
    }

    /**
     * 파라미터 없이 playlist 전체를 반환(return)하는 메서드
     * @return
     */
    public List<Music> findAll() {
        return playlist;
    }

}
