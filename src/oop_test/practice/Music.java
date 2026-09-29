package oop_test.practice;

/**
 * 데이터 객체 Music
 */
public class Music {

    private String title;           // 곡명
    private String artist;          // 아티스트명

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }
}
