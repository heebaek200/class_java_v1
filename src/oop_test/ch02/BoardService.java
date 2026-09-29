package oop_test.ch02;

public class BoardService {

    private BoardDao dao;

    public BoardService() {
        this.dao = new BoardDao();
    }

    public void writePost(String title, String content) {

        Board board = new Board(title, content);
        dao.insertPost(board);

    }

}
