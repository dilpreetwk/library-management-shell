package org.example.shell.client;

import org.example.shell.dto.BorrowOperationDTO;
import org.example.shell.response.BorrowResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface BorrowClient {

    @PostExchange("/borrow/")
    BorrowResponse borrowBook(@RequestBody BorrowOperationDTO borrowOperationDTO);

    @PostExchange("/borrow/return")
    BorrowResponse returnBook(@RequestBody BorrowOperationDTO borrowOperationDTO);
}
