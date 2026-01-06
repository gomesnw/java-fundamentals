package entities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private Instant date;
    private String title;
    private String content;
    private Integer likes;

    private List<Comment> comments = new ArrayList<>();

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                    .withZone(ZoneId.systemDefault());

    public Post(Instant date, String title, String content, Integer likes) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }


    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append('\n');
        sb.append(likes);
        sb.append(" likes - ");
        sb.append(FMT.format(date)).append('\n');
        sb.append(content).append('\n');
        sb.append("Comments:").append('\n');
        for (Comment comment : comments){
            sb.append(comment.getText()).append('\n');
        }
        sb.append('\n');
        return sb.toString();
    }
}
