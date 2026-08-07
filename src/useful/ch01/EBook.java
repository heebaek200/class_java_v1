package useful.ch01;

import java.util.Objects;

public class EBook {

    private int bookTypeId;
    private String title;
    private String author;

    public EBook(int bookTypeId, String title, String author) {
        this.bookTypeId = bookTypeId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "EBook[ " + bookTypeId + ", " + title + ", " + author + " ] " + super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        // 1. 동일 참조 체크
        if (this == obj) return true;

        // 2. 타입 체크
        if (!(obj instanceof EBook)) return false;

        // 3. 필드 논리 비교: 책 제목과 저자가 같으면 같은 책이라고 판별
        EBook target = (EBook) obj;
        return this.bookTypeId == target.bookTypeId &&
                Objects.equals(this.title, target.title) &&
                Objects.equals(this.author, target.author);
    }

    @Override
    public int hashCode() {
        //return super.hashCode();
        return Objects.hash(bookTypeId, title, author);
    }
}
