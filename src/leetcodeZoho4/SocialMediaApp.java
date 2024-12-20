package leetcodeZoho4;

import java.util.ArrayList;
import java.util.List;

// User class: Represents a social media user
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

    // Add a friend
    public void addFriend(User user) {
        if (!friends.contains(user)) {
            friends.add(user);
            System.out.println(username + " is now friends with " + user.getUsername());
        }
    }

    // Create a new post
    public void createPost(String content) {
        Post post = new Post(this, content);
        posts.add(post);
        System.out.println(username + " created a post: " + content);
    }
    
    public Post getPost() {
       return posts.get(posts.size()-1); 
    }

    // Like a post
    public void likePost(Post post) {
        post.addLike(this);
        post.getOwner().receiveNotification(new Notification(this, "liked your post: " + post.getContent()));
    }

    // Comment on a post
    public void commentOnPost(Post post, String commentContent) {
        Comment comment = new Comment(this, commentContent);
        post.addComment(comment);
        post.getOwner().receiveNotification(new Notification(this, "commented on your post: " + commentContent));
    }

    // Receive a notification
    public void receiveNotification(Notification notification) {
        notifications.add(notification);
    }

    // Show all notifications
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

// Post class: Represents a post created by a user
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

    // Add a like
    public void addLike(User user) {
        likes.add(user);
        System.out.println(user.getUsername() + " liked the post: " + content);
    }

    // Add a comment
    public void addComment(Comment comment) {
        comments.add(comment);
        System.out.println(comment.getCommenter().getUsername() + " commented: " + comment.getContent());
    }

    // Show post details
    public void showPost() {
        System.out.println(owner.getUsername() + ": " + content);
        System.out.println("Likes: " + likes.size() + ", Comments: " + comments.size());
        for (Comment comment : comments) {
            System.out.println("\\t" + comment.getCommenter().getUsername() + ": " + comment.getContent());
        }
    }
}

// Comment class: Represents a comment on a post
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

// Notification class: Represents a notification to the user
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

// Main SocialMediaApp class: Manages users and posts
public class SocialMediaApp {
    private List<User> users;

    public SocialMediaApp() {
        users = new ArrayList<>();
    }

    // Register a new user
    public User registerUser(String username) {
        User user = new User(username);
        users.add(user);
        System.out.println("User " + username + " has joined the social media app.");
        return user;
    }

    // Display all users
    public void showAllUsers() {
        System.out.println("All users:");
        for (User user : users) {
            System.out.println("- " + user.getUsername());
        }
    }

    public static void main(String[] args) {
        // Create the social media application instance
        SocialMediaApp app = new SocialMediaApp();

        // Register users
        User alice = app.registerUser("Alice");
        User bob = app.registerUser("Bob");
        User charlie = app.registerUser("Charlie");

        // Users become friends
        alice.addFriend(bob);
        bob.addFriend(charlie);

        // Users create posts
        alice.createPost("Hello, this is my first post!");
        bob.createPost("It's a beautiful day!");

        // Users like and comment on posts
        bob.likePost(alice.getPost());
        charlie.commentOnPost(bob.getPost(), "Indeed it is!");

        // Show notifications for Alice and Bob
        alice.showNotifications();
        bob.showNotifications();

        // View timeline for Alice and Bob
        alice.viewTimeline();
        bob.viewTimeline();
    }
}