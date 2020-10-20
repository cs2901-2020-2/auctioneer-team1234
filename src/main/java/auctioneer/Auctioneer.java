package auctioneer;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private double price;
    private Bidder holder;
    protected boolean biddable = true;

    public Auctioneer(double aPrice) {
        updateHolder(null, aPrice);
    }

    public boolean isBiddable(){
        return biddable;
    }

    public Bidder getHolder(){
        return holder;
    }

    @Override
    public void registerObserver(Observer obs) {
        if (obs != null){
            observers.add(obs);
            obs.update(price);
        }
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

    public boolean updateHolder (Bidder newHolder,double newPrice) {
        if (observers.contains(newHolder) || newHolder == null){
            holder = newHolder;
            price = newPrice;
            biddable = true;
            notifyObservers();
            return true;
        }else return false;
    }

    public void closeAuction(){
        biddable = false;
    }


}
