package auctioneer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Bidder implements Observer{
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double money;
    @Override
    public void update(Object data) {
        HashMap<String, Bid> bids = (HashMap<String, Bid>) data;
        for (Map.Entry<String, Bid> entry : bids.entrySet())
            logger.info (entry.getKey() + " " + String.valueOf(entry.getValue().getPrice()));
    }

    public void bid (Auctioneer auctioneer, String name, double price) {
        auctioneer.registerBid(name, this, price);
    }
}
