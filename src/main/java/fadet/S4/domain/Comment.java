package fadet.S4.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Comment {
    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String nickname;
    private String contents;
    private LocalDateTime comCreateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    // 연관관계 메서드
    public void setPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    // 생성 메서드
    public static Comment createComment(Post post, String nickname, String contents) {
        Comment comment = new Comment();
        comment.setNickname(nickname);
        comment.setContents(contents);
        comment.setComCreateDate(LocalDateTime.now());
        return comment;
    }
}
