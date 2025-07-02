package org.example.be_dreamup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    Xử lý lỗi của @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError fieldError : ex.getBindingResult().getFieldErrors())
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

//    Xử lý lỗi khác như 404
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseEntity<>(Map.of("error", Objects.requireNonNull(ex.getReason())), ex.getStatusCode());
    }

//    Lỗi không xác định
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleOtherExceptions(Exception ex) {
        return new ResponseEntity<>(Map.of("error", "Đã xảy ra lỗi nội bộ"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
