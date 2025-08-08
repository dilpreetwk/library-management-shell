package org.example.shell.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private List<String> genres;

    @Override
    public String toString() {
        return String.format(
                "📘 Book ID: %d%n" +
                        "Title     : %s%n" +
                        "Author    : %s%n" +
                        "Genres    : %s%n",
                id,
                title,
                author,
                String.join(", ", genres)
        );
    }
}
