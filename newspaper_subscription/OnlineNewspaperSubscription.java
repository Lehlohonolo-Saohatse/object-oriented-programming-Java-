public class OnlineNewspaperSubscription extends NewspaperSubscription {
    @Override
    public void setAddress(String subscriberAddress) {
        if (subscriberAddress.contains("@")) {
            this.subscriberAddress = subscriberAddress;
            this.subscriptionRate = 9.0;
        } else {
            System.out.println("Error: Invalid email address format.");
            this.subscriptionRate = 0.0;
        }
    }
}
