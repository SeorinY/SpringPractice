package seorin.org.practice.jwt.login.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserLoginResponseDto {

    private Long userId;
    private String accessToken;

    public static UserLoginResponseDto of(Long userId, String accessToken) {
        return new UserLoginResponseDto(userId, accessToken);
    }
}
