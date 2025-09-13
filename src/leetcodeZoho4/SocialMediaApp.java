package leetcodeZoho4;

import java.util.ArrayList;
import java.util.List;

class User {
	private String username;
	private List<Post> posts;
	private List<User> friends;
	private List<Notification> notifications;

	public User(String username) {
		this.username = username;
		this.posts = new ArrayList<>();
		this.friends = new ArrayList<>();
		this.notifications = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void addFriend(User user) {
		if (!friends.contains(user)) {
			friends.add(user);
			System.out.println(this.username + " is now friends with " + user.getUsername());
		}
	}

	public void createPost(String content) {
		Post post = new Post(this, content);
		posts.add(post);
		System.out.println(this.username + " created a post: " + content);
	}

	public Post getPost() {
		return posts.get(posts.size() - 1);
	}

	public void likePost(Post post) {
		post.addLike(this);
		post.getOwner().receiveNotification(new Notification(this, "liked your post: " + post.getContent()));
	}

	public void commentOnPost(Post post, String commentContent) {
		Comment comment = new Comment(this, commentContent);
		post.addComment(comment);
		post.getOwner().receiveNotification(new Notification(this, "commented on your post: " + commentContent));
	}

	public void receiveNotification(Notification notification) {
		notifications.add(notification);
	}

	public void showNotifications() {
		System.out.println("Notifications for " + username + ":");
		for (Notification notification : notifications) {
			System.out.println(notification.getMessage());
		}
	}

	public void viewTimeline() {
		System.out.println(username + "'s Timeline:");
		for (Post post : posts) {
			post.showPost();
		}
	}
}

class Post {
	private User owner;
	private String content;
	private List<Comment> comments;
	private List<User> likes;

	public Post(User owner, String content) {
		this.owner = owner;
		this.content = content;
		this.comments = new ArrayList<>();
		this.likes = new ArrayList<>();
	}

	public User getOwner() {
		return owner;
	}

	public String getContent() {
		return content;
	}

	public void addLike(User user) {
		likes.add(user);
		System.out.println(user.getUsername() + " liked the post: " + content);
	}

	public void addComment(Comment comment) {
		comments.add(comment);
		System.out.println(comment.getCommenter().getUsername() + " commented: " + comment.getContent());
	}

	public void showPost() {
		System.out.println(owner.getUsername() + ": " + content);
		System.out.println("Likes: " + likes.size() + ", Comments: " + comments.size());
		for (Comment comment : comments) {
			System.out.println("\\t" + comment.getCommenter().getUsername() + ": " + comment.getContent());
		}
	}
}

class Comment {
	private User commenter;
	private String content;

	public Comment(User commenter, String content) {
		this.commenter = commenter;
		this.content = content;
	}

	public User getCommenter() {
		return commenter;
	}

	public String getContent() {
		return content;
	}
}

class Notification {
	private User sender;
	private String message;

	public Notification(User sender, String message) {
		this.sender = sender;
		this.message = sender.getUsername() + " " + message;
	}

	public String getMessage() {
		return message;
	}
}

public class SocialMediaApp {
	private List<User> users;

	public SocialMediaApp() {
		users = new ArrayList<>();
	}

	public User registerUser(String username) {
		User user = new User(username);
		users.add(user);
		System.out.println("User " + username + " has joined the social media app.");
		return user;
	}

	public void showAllUsers() {
		System.out.println("All users:");
		for (User user : users) {
			System.out.println("- " + user.getUsername());
		}
	}

	public static void main(String[] args) {
		SocialMediaApp app = new SocialMediaApp();

		User alice = app.registerUser("Alice");
		User bob = app.registerUser("Bob");
		User charlie = app.registerUser("Charlie");

		alice.addFriend(bob);
		bob.addFriend(charlie);

		alice.createPost("Hello, this is my first post!");
		bob.createPost("It's a beautiful day!");

		bob.likePost(alice.getPost());
		charlie.commentOnPost(bob.getPost(), "Indeed it is!");

		alice.showNotifications();
		bob.showNotifications();

		alice.viewTimeline();
		bob.viewTimeline();
	}
}