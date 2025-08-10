package org.example.shell.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class BorrowResponse {

    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDateTime loanedAt;
    private LocalDateTime returnIn;
    private LocalDateTime returnedAt;


    @Override
    public String toString() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return String.format(
                "📚 Borrow ID : %d%n" +
                        "Book ID     : %d%n" +
                        "User ID     : %d%n" +
                        "Loaned At   : %s%n" +
                        "Return In   : %s%n" +
                        "Returned At : %s%n",
                id,
                bookId,
                userId,
                loanedAt != null ? loanedAt.format(dateFormatter) : "N/A",
                returnIn != null ? returnIn.format(dateFormatter) : "N/A",
                returnedAt != null ? returnedAt.format(dateFormatter) : "N/A"
        );
    }
}
