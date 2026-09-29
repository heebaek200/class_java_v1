package oop_test.tickets;

public class Main {
    public static void main(String[] args) {

//        PricePolicy pricePolicy = new WeekdayPricePolicy();
        PricePolicy pricePolicy = new WeekendPricePolicy();

        TicketService ticketService = new TicketService(pricePolicy);
        ticketService.reserve("아벤쟈-즈", 12_000);

    }
}
