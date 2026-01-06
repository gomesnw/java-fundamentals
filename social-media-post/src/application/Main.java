package application;

import entities.Comment;
import entities.Post;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        Post post1 = new Post(Instant.now(), "Traveling to New Zealand", "I'm going to visit this wonderful country!", 12);
        Comment comment1 = new Comment("Have a nice trip");
        Comment comment2 = new Comment("Wow! That's Awesome!");
        post1.addComment(comment1);
        post1.addComment(comment2);


        Post post2 = new Post(Instant.now(), "Good night guys", "See you tomorrow", 5);
        Comment comment3 = new Comment("Good night");
        Comment comment4 = new Comment("May the force be with you");
        post2.addComment(comment3);
        post2.addComment(comment4);

        System.out.println(post1);
        System.out.println(post2);

        post2.removeComment(comment3);

        System.out.println(post2);
    }
}
