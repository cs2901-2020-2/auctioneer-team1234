package auctioneer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class Auctioneer implements Subject{
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> observers = new ArrayList<Observer>();
    private HashMap<String, Bid> bids;
    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update (bids);
        }
    }

    public void registerBid (String name, Bidder bidder, double price) {
        if (bids.containsKey(name)) {
            if (bids.get(name).getBidder () == bidder) {
                logger.info("You are already the latest bidder.");
                return;
            }
            bids.get(name).updateBid(bidder, price);
        }
        else {
            Bid bid = new Bid(bidder, price);
            bids.put(name, bid);
        }
    }
}
