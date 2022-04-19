package fadet.S4.controller;

import fadet.S4.domain.Post;
import fadet.S4.service.MemberService;
import fadet.S4.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    private final MemberService memberService;

    @GetMapping("/posts/new")
    public String createForm(Model model) {
        model.addAttribute("form", new PostForm());
        return "posts/createPostForm";
    }

    @PostMapping("/posts/new")
    public String createForm(@ModelAttribute("form") PostForm form) {
        Post post = Post.createPost(memberService.findOne(form.getMemberId()), form.getTitle(), form.getContents());
        postService.createPost(post);//화면구현이 힘들어 받는 인자를 줄임
        return "redirect:/posts";
    }
    //조회
    @GetMapping("/posts")
    public String list(Model model) {
        List<Post> posts = postService.findAll();
        model.addAttribute("posts", posts);
        return "posts/postList";
    }
    //수정
    @GetMapping("/posts/{postId}/edit")
    public String updatePostForm(@PathVariable("postId") Long postId, Model model) {
        Post post = postService.findOne(postId);
        PostForm form = new PostForm();
        form.setId(post.getId());
        form.setMemberId(post.getMember().getId());
        form.setTitle(post.getTitle());
        form.setContents(post.getContents());

        model.addAttribute("form", form);
        return "posts/updatePostForm";
    }

    @PostMapping("/posts/{postId}/edit")
    public String update(@PathVariable("postId") Long postId, @ModelAttribute("form") PostForm form) {
        postService.updatePost(postId, form.getTitle(), form.getContents());

        return "redirect:/posts";

    }
}
