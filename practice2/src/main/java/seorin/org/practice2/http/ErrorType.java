package seorin.org.practice2.http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ErrorType {

    /**
     * 400 BAD REQUEST
     */
    REQUEST_VALIDATION_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 요청입니다"),

    NO_REQUEST_PARAMETER_EXCEPTION(HttpStatus.BAD_REQUEST, "요청 파라미터 값이 없습니다"),
    VALIDATION_WRONG_TYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 타입이 입력되었습니다"),

    PARAMETER_TYPE_MISMATCH_EXCEPTION(HttpStatus.BAD_REQUEST, "파라미터의 타입이 잘못됐습니다"),
    INVALID_PASSWORD_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 비밀번호가 입력됐습니다."),
    INVALID_INPUT_EXCEPTION(HttpStatus.BAD_REQUEST, "잘못된 입력 값입니다."),

    /**
     * 401 UNAUTHORIZED
     */
    TOKEN_TIME_EXPIRED_EXCEPTION(HttpStatus.UNAUTHORIZED, "만료된 토큰입니다."),

    /**
     * 404 NOT FOUND
     */
    NOT_FOUND_RESOURCE(HttpStatus.NOT_FOUND, "존재하지 않는 데이터입니다."),
    NOT_FOUND_USER_EXCEPTION(HttpStatus.NOT_FOUND, "존재하지 않는 유저입니다"),

    /**
     * 409 CONFLICT
     */
    ALREADY_EXIST_USER_EXCEPTION(HttpStatus.CONFLICT, "이미 존재하는 유저입니다"),


    /**
     * 500 INTERNAL SERVER ERROR
     */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "알 수 없는 서버 에러가 발생했습니다"),
    ;


    private final HttpStatus httpStatus;
    private final String message;

    public int getHttpStatusCode() {
        return httpStatus.value();
    }

    public String getMessage() {
        return message;
    }
}
