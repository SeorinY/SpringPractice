package seorin.org.practice.exception;

import seorin.org.practice.Http.ErrorType;

public class NotFoundException extends BusinessException {

    public NotFoundException(ErrorType errorType) {
        super(errorType);
    }

    public NotFoundException() {
        super(ErrorType.NOT_FOUND_RESOURCE);
    }
}
