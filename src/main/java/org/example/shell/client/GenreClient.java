package org.example.shell.client;

import org.example.shell.response.GenreResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface GenreClient{

    @GetExchange("/book/genre/{id}")
    GenreResponse getGenreById(@PathVariable Long id);

    @GetExchange("/book/genre/all")
    List<GenreResponse> getAllGenres();
}
