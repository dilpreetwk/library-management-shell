package org.example.shell.command;

import lombok.RequiredArgsConstructor;
import org.example.shell.client.BorrowClient;
import org.example.shell.dto.BorrowOperationDTO;
import org.example.shell.response.BorrowResponse;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class BorrowCommand {

    private final BorrowClient borrowClient;

    @ShellMethod(key = "borrow book", value = "Borrow a book from the library")
    public String borrowBook(Long bookId, Long userId) {
        BorrowOperationDTO borrowOperationDTO = BorrowOperationDTO.builder()
                .userId(userId)
                .bookId(bookId)
                .build();

        BorrowResponse borrowResponse = borrowClient.borrowBook(borrowOperationDTO);

        return borrowResponse.toString();
    }

    @ShellMethod(key = "return book", value = "Return a borrowed book to the library")
    public String returnBook(Long bookId, Long userId) {
        BorrowOperationDTO borrowOperationDTO = BorrowOperationDTO.builder()
                .userId(userId)
                .bookId(bookId)
                .build();

        BorrowResponse borrowResponse = borrowClient.returnBook(borrowOperationDTO);

        return borrowResponse.toString();
    }
}
