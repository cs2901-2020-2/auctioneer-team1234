# Auction

> Using the Observer design pattern, we will simulate a real-time auction.

```java
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

public interface Observer {
    public void update(Object data);
}

```

## Functionalities
- The auctioneer must be able to broadcast the latest bids to all bidders.
- The bidders must be able to bid on the latest price if they have enough money.
- A bidder cannot bid again if they were the last one to bid.

## TODO
- Create a ```Auctioneer``` class that implements ```Subject```.
- Create a ```Bidder``` class that implements ```Observer```.
- Create a ```Auction``` class to test all the functionalities of the classes.
- Create a ```MultithreadAuction``` class to test concurrent ```Bidders``` on the auction.

> Hint: Only one Bidder can accept a bid at a time.
