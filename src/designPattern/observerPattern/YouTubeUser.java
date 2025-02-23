package designPattern.observerPattern;

//Concrete Observer - YouTube User
class YouTubeUser implements Subscriber {
	private String name;

	public YouTubeUser(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void update(String videoTitle) {
		System.out.println(name + " received notification: New video uploaded - " + videoTitle);
	}
}