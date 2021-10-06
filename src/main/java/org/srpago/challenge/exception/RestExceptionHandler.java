package org.srpago.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.srpago.challenge.model.response.Response;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler
        extends ResponseEntityExceptionHandler {

    private static final String MESSAGE_RESOURCE_NOT_FOUND_ERROR = "Recurso no encontrado";
    private static final String MESSAGE_INTERNAL_ERROR = "Error Interno";
    private static final String MESSAGE_CONSTRAINT_ERROR = "Error de Validaciones de Entrada";
    private static final String MESSAGE_GASOLINE_DATA_CLIENT_ERROR = "Error al consultar Servicio externo de Gasoline";



    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<Response> handleResourceNotFoundException(
            ResourceNotFoundException ex) {
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND).
                body(Response.builder().
                        success(Boolean.FALSE).
                        error(ex.getMessage()).
                        message(MESSAGE_RESOURCE_NOT_FOUND_ERROR)
                        .build());
    }

    @ExceptionHandler(PurchaseConstraintException.class)
    protected ResponseEntity<Response> handlePurchaseConstraintException(
            PurchaseConstraintException ex) {
        List<String> errors = ex.getErrors()
                .parallelStream()
                .map(error -> error.getDefaultMessage()
                )
                .collect(Collectors.toList());
        return ResponseEntity.
                status(HttpStatus.CONFLICT).
                body(Response.builder().
                        success(Boolean.FALSE).
                        error(errors.toString()).
                        message(MESSAGE_CONSTRAINT_ERROR)
                        .build());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Response> handleExceptionException(
            Exception ex) {
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(Response.builder().
                        success(Boolean.FALSE).
                        error(ex.getMessage()).
                        message(MESSAGE_INTERNAL_ERROR)
                        .build());
    }

    @ExceptionHandler(GasolineDataClientException.class)
    protected ResponseEntity<Response> handleGasolineDataClientException(
            Exception ex) {
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(Response.builder().
                        success(Boolean.FALSE).
                        error(ex.getMessage()).
                        message(MESSAGE_GASOLINE_DATA_CLIENT_ERROR)
                        .build());
    }
}
