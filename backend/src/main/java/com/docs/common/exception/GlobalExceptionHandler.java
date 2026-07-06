package com.docs.common.exception;

import com.docs.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.failure(ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(
                        ApiResponse.failure(
                                ex.getMessage()
                        )
                );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>>
    handleGenericException(
            Exception exception
    ) {


        return ResponseEntity
                .status(
                        HttpStatus.INTERNAL_SERVER_ERROR
                )
                .body(
                        ApiResponse.failure(
                                "Something went wrong"
                        )
                );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>>
    handleValidationException(
            MethodArgumentNotValidException exception
    ) {


        Map<String,String> errors =
                new HashMap<>();


        exception
                .getBindingResult()
                .getFieldErrors()
                .forEach(
                        error ->
                                errors.put(
                                        error.getField(),
                                        error.getDefaultMessage()
                                )
                );


        return ResponseEntity
                .badRequest()
                .body(
                        ApiResponse.failure(
                                "Validation failed",
                                errors
                        )
                );
    }

}


