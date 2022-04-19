package fadet.S4.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Post {
    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String contents;
    private LocalDateTime PostCreateDate;
    @Enumerated(EnumType.STRING)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    // 연관관계 메서드
    public void setMember(Member member) {
        this.member = member;
        member.getPosts().add(this);
    }

    // 생성 메서드
    public static Post createPost(Member member, String title, String contents) {
        Post post = new Post();
        post.setMember(member);
        post.setTitle(title);
        post.setContents(contents);
        post.setPostCreateDate(LocalDateTime.now());
        return post;
    }

}
