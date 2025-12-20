package dev.naimsulejmani.autokorea2025example.exceptions;

import lombok.Data;

@Data
public class NotFoundException extends RuntimeException {
//    private HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    public NotFoundException(String message) {
        super(message);
    }
}
