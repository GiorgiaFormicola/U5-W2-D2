package GiorgiaFormicola.U5_W2_D2.services;

import GiorgiaFormicola.U5_W2_D2.entities.Author;
import GiorgiaFormicola.U5_W2_D2.exceptions.NotFoundException;
import GiorgiaFormicola.U5_W2_D2.payloads.AuthorPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AuthorsService {
    private final List<Author> authorsDB = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorsDB;
    }

    public Author findById(long authorId) {
        Optional<Author> found = authorsDB.stream().filter(author -> author.getId() == authorId).findAny();
        if (found.isEmpty()) throw new NotFoundException("author", authorId);
        else return found.get();
    }

    public Author saveNewAuthor(AuthorPayload body) {
        Author newAuthor = new Author(body.getName(), body.getSurname(), body.getEmail(), body.getBirthDate());
        this.authorsDB.add(newAuthor);
        log.info("Author with id " + newAuthor.getId() + " has been successfully saved!");
        return newAuthor;
    }

    public Author findByIdAndUpdate(long authorId, AuthorPayload body) {
        Author found = this.findById(authorId);
        found.setName(body.getName());
        found.setSurname(body.getSurname());
        found.setEmail(body.getEmail());
        found.setAvatarURL(body.getAvatarURL());
        found.setBirthDate(body.getBirthDate());
        return found;
    }

    public void findByIdAndDelete(long authorId) {
        Author found = this.findById(authorId);
        this.authorsDB.remove(found);
    }
}
