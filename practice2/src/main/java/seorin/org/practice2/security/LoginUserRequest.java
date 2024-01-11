package seorin.org.practice2.security;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginUserRequest {

	private String email;
	private String password;
}
