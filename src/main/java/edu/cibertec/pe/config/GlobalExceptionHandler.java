package edu.cibertec.pe.config;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import edu.cibertec.pe.response.ErrorResponse;
import edu.cibertec.pe.util.ExceptionValidate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExceptionValidate.class)
    @ResponseStatus( code = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(ExceptionValidate ex) {
        return new ErrorResponse("Se valido ", ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFoundException(NotFoundException ex) {
        return new ErrorResponse("Recurso no encontrado", ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternalServerError(Exception ex) {
        return new ErrorResponse("Error interno del servidor", ex.getMessage());
    }
}
