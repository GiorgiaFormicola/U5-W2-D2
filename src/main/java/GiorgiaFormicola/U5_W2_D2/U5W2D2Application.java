package GiorgiaFormicola.U5_W2_D2;

import GiorgiaFormicola.U5_W2_D2.entities.Author;
import GiorgiaFormicola.U5_W2_D2.entities.BlogPost;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class U5W2D2Application {

    public static void main(String[] args) {

        SpringApplication.run(U5W2D2Application.class, args);
        BlogPost newBlogPost = new BlogPost("tech", "Post1", "provapost", LocalTime.of(1, 20));
        System.out.println(newBlogPost);
        Author newAuthor = new Author("Mario", "Rossi", "mariorossi@gmail.com", LocalDate.of(1997, 8, 12));
        System.out.println(newAuthor);
    }

}
