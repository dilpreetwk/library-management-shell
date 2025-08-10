package org.example.shell.command;

import lombok.RequiredArgsConstructor;
import org.example.shell.client.GenreClient;
import org.example.shell.response.GenreResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class GenreCommand {

    private final GenreClient genreClient;

    @ShellMethod(key = "genre get", value = "Get genre by id")
    public String getGenreById(Long id) {
        GenreResponse genreResponse = genreClient.getGenreById(id);
        return genreResponse.toString();
    }

    @ShellMethod(key = "genre ls", value = "List all genres")
    public String listGenres() {
        return genreClient.getAllGenres().stream()
                .map(GenreResponse::toString)
                .collect(Collectors.joining("\n"));
    }
}
