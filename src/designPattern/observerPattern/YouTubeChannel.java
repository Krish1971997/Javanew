
package designPattern.observerPattern;

interface YouTubeChannel {
	void subscribe(Subscriber subscriber);

	void unsubscribe(Subscriber subscriber);

	void notifySubscribers(String videoTitle);
}