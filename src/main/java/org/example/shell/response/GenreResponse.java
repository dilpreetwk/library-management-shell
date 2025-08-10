package org.example.shell.response;

import lombok.Data;

@Data
public class GenreResponse {

    private Long id;
    private String name;

    @Override
    public String toString() {
        return id + ". " + name;
    }
}
