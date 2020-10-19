package auctioneer;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Bidder implements Observer{
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double money;
    private double currentBid;
    @Override
    public void update(Object data) {
        currentBid = (double) data;
    }

    public synchronized void bid (Auctioneer auctioneer) {
        if (money >= currentBid && auctioneer.biddable && auctioneer.getHolder() != this) {
            auctioneer.updateHolder(this);
            auctioneer.biddable = false;
        }
        else
            logger.info("You cannot bid.");
    }
}
