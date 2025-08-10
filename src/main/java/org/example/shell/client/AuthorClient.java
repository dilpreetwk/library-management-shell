package org.example.shell.client;

import org.example.shell.response.AuthorResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface AuthorClient {

    @GetExchange("/book/author/{id}")
    AuthorResponse getAuthorById(@PathVariable Long id);

    @GetExchange("/book/author/all")
    List<AuthorResponse> getAllAuthors();
}
