package org.srpago.challenge.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Response{

    private Boolean success;
    private String error;
    private String message;

}
