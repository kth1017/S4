package fadet.S4.service;

import fadet.S4.domain.Post;
import fadet.S4.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void createPost(Post post) {
        postRepository.save(post);
    }
    //조회
    public Post findOne(Long postId) {
        return postRepository.findOne(postId);
    }
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional
    public void updatePost(Long postId, String title, String contents) {
        Post findPost = postRepository.findOne(postId);
        findPost.setTitle(title);
        findPost.setContents(contents);
    }
}
