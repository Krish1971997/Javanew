package designPattern.observerPattern;

public class YouTubeNotificationSystem {
    public static void main(String[] args) {
        // Create a YouTube channel
        MyYouTubeChannel channel = new MyYouTubeChannel("TechExplained");

        // Create subscribers
        Subscriber user1 = new YouTubeUser("Alice");
        Subscriber user2 = new YouTubeUser("Bob");
        Subscriber user3 = new YouTubeUser("Charlie");

        // Subscribers subscribe to the channel
        channel.subscribe(user1);
        channel.subscribe(user2);
        channel.subscribe(user3);

        // Uploading a new video - Notify all subscribers
        channel.notifySubscribers("Observer Pattern in Java");

        // Bob unsubscribes
        channel.unsubscribe(user2);

        // Uploading another video - Notify remaining subscribers
        channel.notifySubscribers("Design Patterns for Beginners");
    }
}