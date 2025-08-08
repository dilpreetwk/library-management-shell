package org.example.shell.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.Set;

@Data
public class BookInsertUpdateDTO {

    @NotEmpty(message = "title is required")
    private String title;

    @NotEmpty(message = "author is required")
    private Long authorId;

    @NotEmpty(message = "book belongs to atleast one genre")
    private Set<Long> genres;
}
