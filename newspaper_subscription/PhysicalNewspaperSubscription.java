public class PhysicalNewspaperSubscription extends NewspaperSubscription {
    @Override
    public void setAddress(String subscriberAddress) {
        if (subscriberAddress.matches(".*\\d.*")) {
            this.subscriberAddress = subscriberAddress;
            this.subscriptionRate = 15.0;
        } else {
            System.out.println("Error: Address must contain at least one digit.");
            this.subscriptionRate = 0.0;
        }
    }
}