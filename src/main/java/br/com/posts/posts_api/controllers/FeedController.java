package br.com.posts.posts_api.controllers;

import br.com.posts.posts_api.dtos.PostResponse;
import br.com.posts.posts_api.entities.Post;
import br.com.posts.posts_api.repositories.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeedController {

    private PostRepository postRepository;

    public FeedController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/feed")
    public List<PostResponse> feed() {
        return postRepository.findAll().stream().map(PostResponse::new).toList();
    }
}
