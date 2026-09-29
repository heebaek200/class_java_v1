package oop_test.tickets;

import java.text.NumberFormat;

public class Ticket {

    private String movieTitle;
    private int price;

    public Ticket(String movieTitle, int price) {
        this.movieTitle = movieTitle;
        this.price = price;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "티켓 | 제목 : %s, 가격 : %s".formatted(
                movieTitle,
                NumberFormat.getInstance().format(price)
        );
    }
}
