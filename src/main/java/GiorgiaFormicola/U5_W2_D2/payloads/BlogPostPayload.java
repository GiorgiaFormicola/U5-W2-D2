package GiorgiaFormicola.U5_W2_D2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class BlogPostPayload {
    private String category;
    private String title;
    private String coverURL;
    private String content;
    private int readingTime;
}
