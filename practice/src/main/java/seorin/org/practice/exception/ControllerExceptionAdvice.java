package seorin.org.practice.exception;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import seorin.org.practice.http.ApiResponse;
import seorin.org.practice.http.ErrorType;

import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 400 BAD_REQUEST
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = Objects.requireNonNull(e.getFieldError());
        return ApiResponse.error(ErrorType.REQUEST_VALIDATION_EXCEPTION,
                String.format("%s. (%s)", fieldError.getDefaultMessage(), fieldError.getField()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e) {
        return ApiResponse.error(ErrorType.INVALID_INPUT_EXCEPTION);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<?> handleDateTimeFormatException(HttpMessageNotReadableException e) {
        return ApiResponse.error(ErrorType.INVALID_INPUT_EXCEPTION);
    }

    /**
     * 500 Internal Server
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleInternalServerException(Exception e) {
        return ApiResponse.error(ErrorType.INTERNAL_SERVER_ERROR);
    }

    /**
     * custom error
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<?> handleBusinessException(BusinessException e) {
        //ReusableRequestWrapper request 파라미터로 받아서
        // e.getMessage  로그로 남기기
        return ApiResponse.error(e.getErrorType());
    }


}

