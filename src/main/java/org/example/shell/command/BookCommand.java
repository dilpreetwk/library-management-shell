package org.example.shell.command;

import lombok.RequiredArgsConstructor;
import org.example.shell.client.BookClient;
import org.example.shell.response.BookResponse;
import org.example.shell.response.PageResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.stream.Collectors;

@ShellComponent
@RequiredArgsConstructor
public class BookCommand {

    private final BookClient bookClient;

    @ShellMethod(key = "book get", value = "Get book by ID")
    public String getBookById(Long id) {
        BookResponse bookResponse = bookClient.getBookById(id);
        return bookResponse.toString();
    }

    @ShellMethod(key = "book ls", value = "List all books")
    public String listBooks(
            @ShellOption(defaultValue = "5") int pageSize,
            @ShellOption(defaultValue = "0") int pageNumber,
            @ShellOption(defaultValue = "title") String sort,
            @ShellOption(defaultValue = "ASC") String sortDirection,
            @ShellOption(defaultValue = "") String search
    ) {
        PageResponse<BookResponse> pageResponses = bookClient.getAllBooks(pageSize, pageNumber, sort, sortDirection, search);
        return pageResponses.getContent().stream()
                .map(BookResponse::toString)
                .collect(Collectors.joining("\n"));
    }
}
