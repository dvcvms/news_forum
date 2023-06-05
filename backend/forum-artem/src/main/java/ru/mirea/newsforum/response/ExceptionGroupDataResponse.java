package ru.mirea.newsforum.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionGroupDataResponse extends AbstractExceptionResponse {
    private String code;
    private String message;
}
