package designPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

class MyYouTubeChannel implements YouTubeChannel {
	private List<Subscriber> subscribers = new ArrayList<>();
	private String channelName;

	public MyYouTubeChannel(String channelName) {
		this.channelName = channelName;
	}

	@Override
	public void subscribe(Subscriber subscriber) {
		subscribers.add(subscriber);
		System.out.println(((YouTubeUser) subscriber).getName() + " subscribed to " + channelName);
	}

	@Override
	public void unsubscribe(Subscriber subscriber) {
		subscribers.remove(subscriber);
		System.out.println(((YouTubeUser) subscriber).getName() + " unsubscribed from " + channelName);
	}

	@Override
	public void notifySubscribers(String videoTitle) {
		System.out.println("\n📢 " + channelName + " uploaded a new video: " + videoTitle);
		for (Subscriber subscriber : subscribers) {
			subscriber.update(videoTitle);
		}
	}
}
