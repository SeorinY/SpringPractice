package seorin.org.practice.exception;

import seorin.org.practice.Http.ErrorType;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(ErrorType errorType) {
        super(errorType);
    }

    //예시
    public UnauthorizedException() {
        super(ErrorType.TOKEN_TIME_EXPIRED_EXCEPTION);
    }
}
