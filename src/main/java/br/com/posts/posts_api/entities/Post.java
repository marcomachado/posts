package br.com.posts.posts_api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
public class Post {

    public enum PostType {
        ORIGINAL, REPOST, QUOTE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max=42)
    private String content;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(columnDefinition = "enum(ORIGINAL', 'REPOST', 'QUOTE')")
    private PostType type;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @NotNull
    private User author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name =  "original_post_id")
    private Post originalPost;

    @NotNull
    private LocalDateTime createdAt;

    @Deprecated
    protected Post(){}

    public Post(Long id, String content, PostType type, User author) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public PostType getType() {
        return type;
    }

    public User getAuthor() {
        return author;
    }

    public Optional<Post> getOriginalPost() {
        return Optional.ofNullable(originalPost);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
