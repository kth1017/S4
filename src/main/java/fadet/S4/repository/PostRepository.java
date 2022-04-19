package fadet.S4.repository;

import fadet.S4.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {
    public final EntityManager em;

    public void save(Post post) {
            em.persist(post);
    }

    public Post findOne(Long postId) {
        return em.find(Post.class, postId);
    }

    public List<Post> findAll() {
        return em.createQuery("select p from Post p",Post.class).getResultList();
    }
}
