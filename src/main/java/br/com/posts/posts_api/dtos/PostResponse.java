package br.com.posts.posts_api.dtos;

import br.com.posts.posts_api.entities.Post;
import br.com.posts.posts_api.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {

    @JsonProperty
    private final Long id;
    @JsonProperty
    private final String content;
    @JsonProperty
    private final Post.PostType type;
    @JsonProperty
    private final String authorUsername;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.content = post.getContent();
        this.type = post.getType();
        this.authorUsername = post.getAuthor().getUsername();
    }
}
