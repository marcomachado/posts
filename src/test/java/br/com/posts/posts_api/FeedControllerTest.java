package br.com.posts.posts_api;

import br.com.posts.posts_api.entities.Post;
import br.com.posts.posts_api.entities.User;
import br.com.posts.posts_api.repositories.PostRepository;
import br.com.posts.posts_api.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static br.com.posts.posts_api.entities.Post.PostType.ORIGINAL;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class FeedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("should return a feed of posts")
    void t1() throws Exception {
        User user1 = userRepository.save(new User(1L, "marco"));

        postRepository.saveAll(List.of(
                new Post(1L, "siga o podcast", ORIGINAL, user1),
                new Post(2L, "code code code", ORIGINAL, user1)
        ));


        mockMvc.perform(get("/feed"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))

                .andExpect(jsonPath("$[0].id").isNotEmpty())
                .andExpect(jsonPath("$[0].content").value("siga o podcast"))
                .andExpect(jsonPath("$[0].authorUsername").value("marco"))
                .andExpect(jsonPath("$[0].type").value("ORIGINAL"))

                .andExpect(jsonPath("$[1].id").isNotEmpty())
                .andExpect(jsonPath("$[1].content").value("code code code"))
                .andExpect(jsonPath("$[1].authorUsername").value("marco"))
                .andExpect(jsonPath("$[1].type").value("ORIGINAL"));

    }

}
















