package seorin.org.practice2.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seorin.org.practice2.entity.User;
import seorin.org.practice2.repository.UserRepository;

@RequiredArgsConstructor
@RequestMapping("/security")
@RestController
public class SecurityController {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@GetMapping("/test")
	public String securityTest() {
		String rawPassword = "password11";
		String encPassword = passwordEncoder.encode(rawPassword);
		System.out.println("encPassword = " + encPassword);
		return "encPassword = " + encPassword;
	}

	@PostMapping
	public String signUp(LoginUserRequest request) {
		User user = new User();
		user.setUsername("testName");
		user.setEmail(request.getEmail());
		String rawPassword = user.getPassword();
		String encPassword = passwordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "sign up success";
	}

//	@PostMapping
//	public String login() {
//
//	}
}

