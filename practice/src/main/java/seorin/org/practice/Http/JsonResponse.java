package seorin.org.practice.Http;

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
}
