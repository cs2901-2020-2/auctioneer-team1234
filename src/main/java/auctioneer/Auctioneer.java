package auctioneer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public class Auctioneer implements Subject{
    static private final Logger logger = Logger.getLogger(Auctioneer.class.getName());
    private List<Observer> observers = new ArrayList<Observer>();
    private double price;
    private Bidder holder;
    protected boolean biddable = true;
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
            obs.update (price);
        }
    }
    public void updateHolder (Bidder newHolder) { holder = newHolder;}
    public Bidder getHolder () { return holder; }
    public void updatePrice (double newPrice) {
        price = newPrice;
        biddable = true;
        notifyObservers();
    }
}
