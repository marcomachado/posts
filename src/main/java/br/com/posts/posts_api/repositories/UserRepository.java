package br.com.posts.posts_api.repositories;


import br.com.posts.posts_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
