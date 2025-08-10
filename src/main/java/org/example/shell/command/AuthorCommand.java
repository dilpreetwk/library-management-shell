package org.example.shell.command;

import lombok.RequiredArgsConstructor;
import org.example.shell.client.AuthorClient;
import org.example.shell.response.AuthorResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class AuthorCommand {

    private final AuthorClient authorClient;

    @ShellMethod(key = "author get", value = "Get author by id")
    public String getAuthorById(Long id) {
        AuthorResponse authorResponse = authorClient.getAuthorById(id);
        return authorResponse.toString();
    }

    @ShellMethod(key = "author ls", value = "List all authors")
    public String getAllAuthors() {
        return authorClient.getAllAuthors().stream()
                .map(AuthorResponse::toString)
                .collect(Collectors.joining("\n"));
    }
}
