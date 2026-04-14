package GiorgiaFormicola.U5_W2_D2.services;

import GiorgiaFormicola.U5_W2_D2.entities.BlogPost;
import GiorgiaFormicola.U5_W2_D2.exceptions.NotFoundException;
import GiorgiaFormicola.U5_W2_D2.payloads.BlogPostPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BlogPostsService {
    private final List<BlogPost> blogPostsDB = new ArrayList<>();

    public List<BlogPost> findAll() {
        return this.blogPostsDB;
    }

    public BlogPost findById(long blogPostId) {
        Optional<BlogPost> found = blogPostsDB.stream().filter(blogPost -> blogPost.getId() == blogPostId).findAny();
        if (found.isEmpty()) throw new NotFoundException("blog post", blogPostId);
        else return found.get();
    }

    public BlogPost saveNewBlogPost(BlogPostPayload body) {
        BlogPost newBlogPost = new BlogPost(body.getCategory(), body.getTitle(), body.getContent(), body.getReadingTime());
        this.blogPostsDB.add(newBlogPost);
        log.info("Blog post with id " + newBlogPost.getId() + " has been successfully saved!");
        return newBlogPost;
    }

    public BlogPost findByIdAndUpdate(long blogPostId, BlogPostPayload body) {
        BlogPost found = this.findById(blogPostId);
        found.setCategory(body.getCategory());
        found.setTitle(body.getTitle());
        found.setContent(body.getContent());
        found.setCoverURL(body.getCoverURL());
        found.setReadingTime(body.getReadingTime());
        return found;
    }

    public void findByIdAndDelete(long blogPostId) {
        BlogPost found = this.findById(blogPostId);
        this.blogPostsDB.remove(found);
    }


}
