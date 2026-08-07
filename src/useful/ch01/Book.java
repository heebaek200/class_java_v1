package useful.ch01;

//import java.lang.String;
//import java.lang.*;           // <- 자동 import이므로 명시할 필요 없다

// Object 클래스 활용 예제
public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "[ " + title + ", " + author + " ] " + super.toString();
    }

    public static void main(String[] args) {

        Book book = new Book("데미안", "헤르만헤세");
        Book book2 = book;
        Book book3 = new Book("데미안", "헤르만헤세");

        System.out.println(book);
        System.out.println(book.toString()); // 상동

        System.out.println("-------------------------------");
        System.out.println("Logging1 - Title of Book: " + book.title);

        System.out.println("-------------------------------");
        System.out.println(book.equals(book3));

        // 논리적으로 같은 객체라고 판별하고 싶을 때 equals() 메서드를 재정의해서 활용할 수 있다
        // 단, equals() 메서드를 재정의할 떄 반드시 .hashCode()도 함께 재정의해야 한다.

        System.out.println(book.hashCode());


    }

}
