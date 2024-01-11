package seorin.org.practice.jwt.userId;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import seorin.org.practice.jwt.JwtService;


@RequiredArgsConstructor
@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {
// HandlerMethodArgumentResolver : 특정 조건에 맞는 파라미터가 있을 때 원하는 값을 바인딩해주는 인터페이스

    private final JwtService jwtService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        // 이걸로 UserIdResolver 를 가져와서 resolveArgument 함수를 실행함.
        // Long 으로 매필할 거면 아래처럼!!
        // User 로 매핑할 거면  User.class 로 하자
        return parameter.hasParameterAnnotation(UserId.class) && Long.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(@NotNull MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  @NotNull NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        final HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        final String token = request.getHeader("Authorization");
//        String token = webRequest.getHeader("Authorization");

        // 토큰 검증
        if (!jwtService.verifyToken(token)) {
            throw new RuntimeException(String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
        }

        // 유저 아이디 반환
        final String tokenContents = jwtService.getJwtContents(token);
        try {
            return Long.parseLong(tokenContents);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.format("USER_ID를 가져오지 못했습니다. (%s - %s)", parameter.getClass(), parameter.getMethod()));
        }
    }
}