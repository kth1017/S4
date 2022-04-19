package fadet.S4.controller;

import fadet.S4.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PostForm {
    private Long id;

    private Long memberId;
    private String title;
    private String contents;
    private Category category;
}
