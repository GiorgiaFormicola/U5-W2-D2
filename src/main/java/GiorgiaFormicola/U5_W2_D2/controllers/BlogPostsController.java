package GiorgiaFormicola.U5_W2_D2.controllers;

import GiorgiaFormicola.U5_W2_D2.entities.BlogPost;
import GiorgiaFormicola.U5_W2_D2.payloads.BlogPostPayload;
import GiorgiaFormicola.U5_W2_D2.services.BlogPostsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
@AllArgsConstructor
public class BlogPostsController {
    private final BlogPostsService blogPostsService;

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return this.blogPostsService.findAll();
    }

    @GetMapping("/{blogPostId}")
    public BlogPost getBlogPostById(@PathVariable long blogPostId) {
        return this.blogPostsService.findById(blogPostId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlogPost createBlogPost(@RequestBody BlogPostPayload body) {
        return this.blogPostsService.saveNewBlogPost(body);
    }

    @PutMapping("/{blogPostId}")
    public BlogPost getBlogPostByIdAndUpdate(@PathVariable long blogPostId, @RequestBody BlogPostPayload body) {
        return this.blogPostsService.findByIdAndUpdate(blogPostId, body);
    }

    @DeleteMapping("/{blogPostId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getBlogPostByIdAndDelete(@PathVariable long blogPostId) {
        this.blogPostsService.findByIdAndDelete(blogPostId);
    }
}
