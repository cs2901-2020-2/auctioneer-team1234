package auctioneer;

import java.util.logging.Logger;

public class Bidder implements Observer{
    static private final Logger logger = Logger.getLogger(Bidder.class.getName());
    private double money;
    private double currentBid;

    public Bidder(double nMoney){
        money = nMoney;
    }

    public void addMoney(double more){
        money = more + money;
    }

    public double getMoney(){
        return money;
    }

    @Override
    public void update(Object data) {
        currentBid = (double) data;
    }

    public synchronized boolean bid (Auctioneer auctioneer) {
        if (money >= currentBid && auctioneer.biddable) {
            return auctioneer.updateHolder(this, money);
        } else{
            logger.info("You cannot bid.");
            return false;
        }

    }
}
