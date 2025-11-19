public abstract class NewspaperSubscription {
    private String subscriberName;
    protected String subscriberAddress;
    protected double subscriptionRate;

    public String getSubscriberName() {
        return subscriberName;
    }

    public void setSubscriberName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    public String getSubscriberAddress() {
        return subscriberAddress;
    }

    public double getSubscriptionRate() {
        return subscriptionRate;
    }

    public abstract void setAddress(String subscriberAddress);
}