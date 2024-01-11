package seorin.org.practice2.jwt.login.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginResponseDto {

    private Long userId;
    private String accessToken;

    public static UserLoginResponseDto of(Long userId, String accessToken) {
        return new UserLoginResponseDto(userId, accessToken);
    }
}
