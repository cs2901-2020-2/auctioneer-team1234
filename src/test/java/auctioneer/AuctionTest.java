package auctioneer;


import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class AuctionTest {
    @Test
    public void testBidder(){
        Bidder bidder1 = new Bidder(100);
        Assert.assertEquals(bidder1.getMoney(), 100);
        bidder1.addMoney(200);
        Assert.assertEquals(bidder1.getMoney(), 200+100);
        Auctioneer auctioneer = new Auctioneer(0);
        auctioneer.registerObserver(bidder1);
        Assert.assertTrue(bidder1.bid(auctioneer));
        Assert.assertEquals(auctioneer.getHolder(), bidder1);
    }

    @Test
    public void testAuction() {
        Bidder bidder1 = new Bidder(100);
        Bidder bidder2 = new Bidder(200);
        Bidder bidder3 = new Bidder(300);
        Auctioneer auctioneer1 = new Auctioneer(200);
        Assert.assertFalse(bidder1.bid(auctioneer1));
        Assert.assertFalse(bidder2.bid(auctioneer1));
        Assert.assertFalse(bidder3.bid(auctioneer1));
        auctioneer1.registerObserver(bidder1);
        auctioneer1.registerObserver(bidder2);
        auctioneer1.registerObserver(bidder3);
        Assert.assertFalse(bidder1.bid(auctioneer1));
        Assert.assertTrue(bidder2.bid(auctioneer1));
        Assert.assertTrue(bidder3.bid(auctioneer1));
        auctioneer1.closeAuction();
        Assert.assertFalse(auctioneer1.isBiddable());

        bidder1.addMoney(1000);
        Assert.assertFalse(bidder1.bid(auctioneer1));
    }
}
