package oop_test.tickets;

public class TicketService {

    private PricePolicy pricePolicy;

    public TicketService(PricePolicy pricePolicy) {
        this.pricePolicy = pricePolicy;
    }

    public void reserve(String moveTitle, int price) {
        int finalPrice = pricePolicy.calculate(price);
        Ticket myTicket = new Ticket(moveTitle, finalPrice);

        System.out.println(myTicket.toString());
    }
}
