package ru.mirea.newsforum.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.mirea.newsforum.exception.CustomException;
import ru.mirea.newsforum.response.ExceptionGroupDataResponse;

@ControllerAdvice
public class ForumControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ExceptionGroupDataResponse> handleException(CustomException e) {
        ExceptionGroupDataResponse response = ExceptionGroupDataResponse.builder()
                .code(e.getCode())
                .message(e.getMessage())
                .build();


        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
