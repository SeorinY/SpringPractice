package seorin.org.practice2.exception;


import seorin.org.practice2.http.ErrorType;

public class UnauthorizedException extends BusinessException {

    public UnauthorizedException(ErrorType errorType) {
        super(errorType);
    }

    //예시
    public UnauthorizedException() {
        super(ErrorType.TOKEN_TIME_EXPIRED_EXCEPTION);
    }
}
