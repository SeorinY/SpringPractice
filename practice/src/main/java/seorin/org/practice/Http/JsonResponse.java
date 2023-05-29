package seorin.org.practice.controller.Http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class JsonResponse<T> {

    private final int code;
    private final String message;
    private T data;

//    public static ApiResponse success(Success success) {
//        return new ApiResponse<>(success.getHttpStatusCode(), success.getMessage());
//    }
//
//    public static <T> ApiResponse<T> success(Success success, T data) {
//        return new ApiResponse<T>(success.getHttpStatusCode(), success.getMessage(), data);
//    }
//
//    public static ApiResponse error(Error error) {
//        return new ApiResponse<>(error.getHttpStatusCode(), error.getMessage());
//    }
//
//    public static ApiResponse error(Error error, String message) {
//        return new ApiResponse<>(error.getHttpStatusCode(), message);
//    }
}
