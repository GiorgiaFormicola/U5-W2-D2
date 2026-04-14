package GiorgiaFormicola.U5_W2_D2.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;

@Getter
@Slf4j
@ToString
public class BlogPost {
    private static long blogPostsCounter;
    @Setter(AccessLevel.NONE)
    private long id;
    private String category;
    private String title;
    private String coverURL;
    private String content;
    private int readingTime;

    public BlogPost(String category, String title, String content, LocalTime readingTime) {
        blogPostsCounter++;
        this.id = blogPostsCounter;
        this.category = category;
        this.title = title;
        this.coverURL = "https://picsum.photos/200/300";
        this.content = content;
        this.readingTime = readingTime.getHour() * 60 + readingTime.getMinute();
    }
}
