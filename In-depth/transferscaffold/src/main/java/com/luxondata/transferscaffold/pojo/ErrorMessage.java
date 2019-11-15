package com.luxondata.transferscaffold.pojo;

import lombok.Data;

/**
 * ErrorMessage
 *
 * @author dusk
 * @since 15/11/2019
 */
@Data
public class ErrorMessage {

    private String code;
    private String message;

    public static ErrorMessage errorMessage(String code, String message) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setCode(code);
        errorMessage.setMessage(message);
        return errorMessage;
    }
}
