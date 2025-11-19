public class DemoSubscriptions {
    public static void main(String[] args) {
        PhysicalNewspaperSubscription physicalSubscription = new PhysicalNewspaperSubscription();
        physicalSubscription.setSubscriberName("Lehlohonolo Saohatse");
        physicalSubscription.setAddress("1 reviera park");
        System.out.println("Physical Subscription - Name: " + physicalSubscription.getSubscriberName() +
                ", Address: " + physicalSubscription.getSubscriberAddress() +
                ", Rate: R" + physicalSubscription.getSubscriptionRate());

        OnlineNewspaperSubscription onlineSubscription = new OnlineNewspaperSubscription();
        onlineSubscription.setSubscriberName("Thabang Saohatse");
        onlineSubscription.setAddress("thabang@gmail.com");
        System.out.println("Online Subscription - Name: " + onlineSubscription.getSubscriberName() +
                ", Address: " + onlineSubscription.getSubscriberAddress() +
                ", Rate: R" + onlineSubscription.getSubscriptionRate());
    }
}