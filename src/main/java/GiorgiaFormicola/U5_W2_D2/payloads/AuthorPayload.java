package GiorgiaFormicola.U5_W2_D2.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatarURL;
}
