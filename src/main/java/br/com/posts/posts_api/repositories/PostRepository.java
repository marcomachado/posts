package br.com.posts.posts_api.repositories;

import br.com.posts.posts_api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
