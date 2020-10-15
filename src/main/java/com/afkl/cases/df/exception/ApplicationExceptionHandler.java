package com.afkl.cases.df.exception;

import com.afkl.cases.df.exception.model.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApplicationExceptionHandler {
    @ExceptionHandler(JsonProcessingException.class)
    ResponseEntity<ErrorResponse> jsonProcessingException(Exception e) {
        log.error(e.getMessage());

        ErrorResponse error = new ErrorResponse("Json Processing Exception", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {BadRequestException.class, FareCalculationException.class})
    ResponseEntity<ErrorResponse> invalidRequestException(Exception e) {
        log.error(e.getMessage());

        ErrorResponse error = new ErrorResponse("Invalid request", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<ErrorResponse> applicationException(Exception e) {
        log.error(e.getMessage());

        ErrorResponse error = new ErrorResponse("Internal server error", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
