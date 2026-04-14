package GiorgiaFormicola.U5_W2_D2.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Author {
    private static long authorsCounter;
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate birthDate;
    private String avatarURL;

    public Author(String name, String surname, String email, LocalDate birthDate) {
        authorsCounter++;
        this.id = authorsCounter;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.avatarURL = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }
}
