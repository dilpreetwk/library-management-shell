package org.example.shell.client;

import org.example.shell.dto.BookInsertUpdateDTO;
import org.example.shell.response.BookResponse;
import org.example.shell.response.PageResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface BookClient {

    @GetExchange("/book/{id}")
    BookResponse getBookById(@PathVariable Long id);

    @GetExchange("/book/")
    PageResponse<BookResponse> getAllBooks(
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "sort", required = false) String sort,
            @RequestParam(value = "sortDirection", required = false) String sortDirection,
            @RequestParam(value = "search", required = false) String search
    );

    @PostExchange("/book")
    BookResponse insertBook(@RequestBody BookInsertUpdateDTO bookInsertUpdateDTO);

    @PutExchange("/book/{id}")
    BookResponse updateBook(@PathVariable Long id, @RequestBody BookInsertUpdateDTO bookInsertUpdateDTO);

    @DeleteExchange("/book/{id}")
    BookResponse deleteBook(@PathVariable Long id);
}
