package ru.mirea.newsforum.response;

import lombok.Data;

@Data
public class ExceptionDataResponse<T extends AbstractExceptionResponse> {
    private T error;
}
