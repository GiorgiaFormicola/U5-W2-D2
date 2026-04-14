package GiorgiaFormicola.U5_W2_D2.controllers;

import GiorgiaFormicola.U5_W2_D2.entities.Author;
import GiorgiaFormicola.U5_W2_D2.payloads.AuthorPayload;
import GiorgiaFormicola.U5_W2_D2.services.AuthorsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@AllArgsConstructor
public class AuthorsController {
    private final AuthorsService authorsService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return this.authorsService.findAll();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable long authorId) {
        return this.authorsService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createNewAuthor(@RequestBody AuthorPayload body) {
        return this.authorsService.saveNewAuthor(body);
    }

    @PutMapping("/{authorId}")
    public Author getAuthorByIdAndUpdate(@PathVariable long authorId, @RequestBody AuthorPayload body) {
        return this.authorsService.findByIdAndUpdate(authorId, body);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void getAuthorByIdAndDelete(@PathVariable long authorId) {
        this.authorsService.findByIdAndDelete(authorId);
    }
}
