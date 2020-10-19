package auctioneer;

public class Bid {
    private double price;
    private Bidder bidder;
    public Bid() {}
    public Bid (Bidder b, double p) {
        updateBid(b, p);
    }
    public void updateBid (Bidder b, double p) {
        bidder = b;
        price = p;
    }

    public Bidder getBidder () {return bidder;}
    public double getPrice () {return price;}
}