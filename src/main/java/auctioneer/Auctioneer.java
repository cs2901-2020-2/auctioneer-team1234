package auctioneer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Auctioneer implements Subject{
    private List<Observer> observers = new ArrayList<Observer>();
    private HashMap<String, Observer> bids;
    @Override
    public void registerObserver(Observer obs) {

    }

    @Override
    public void removeObserver(Observer obs) {

    }

    @Override
    public void notifyObservers() {

    }
}
