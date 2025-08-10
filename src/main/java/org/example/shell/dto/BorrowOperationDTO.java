package org.example.shell.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BorrowOperationDTO {

    private Long bookId;
    private Long userId;
}
