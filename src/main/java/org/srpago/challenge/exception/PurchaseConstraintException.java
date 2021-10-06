package org.srpago.challenge.exception;

import org.springframework.validation.ObjectError;
import java.util.List;

public class PurchaseConstraintException extends Exception{

    private static final long serialVersionUID = 1L;
    private List<ObjectError> errors;

    public PurchaseConstraintException(List<ObjectError> errors, String message){
        super(message);
        this.errors = errors;
    }

    public List<ObjectError> getErrors(){
        return errors;
    }
}
