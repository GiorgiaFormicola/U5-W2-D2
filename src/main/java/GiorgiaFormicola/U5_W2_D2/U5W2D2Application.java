package GiorgiaFormicola.U5_W2_D2;

import GiorgiaFormicola.U5_W2_D2.services.BlogPostsService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class U5W2D2Application {

    private final BlogPostsService bpService;

    public static void main(String[] args) {

        SpringApplication.run(U5W2D2Application.class, args);
        
    }

}
