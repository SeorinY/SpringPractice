package seorin.org.practice.jwt.login;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seorin.org.practice.http.ApiResponse;
import seorin.org.practice.http.SuccessType;
import seorin.org.practice.jwt.JwtService;
import seorin.org.practice.jwt.login.dto.UserLoginRequestDto;
import seorin.org.practice.jwt.login.dto.UserLoginResponseDto;
import seorin.org.practice.jwt.userId.UserId;


@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class UserController {

    private final JwtService jwtService;


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> login(@RequestBody @Valid final UserLoginRequestDto request) {
        final Long userId = 10L;  //userService.login(request)
        final String token = jwtService.issuedToken(String.valueOf(userId));
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS, UserLoginResponseDto.of(userId, token));
    }

    @PostMapping("/test1")
    public ResponseEntity<?> login1(
            @RequestHeader("Authorization") String accessToken) {
        // 필터에서 JWT 관련 exception 다 처리해주기
        String stringUserId = jwtService.getJwtContents(accessToken);
        Long userId = Long.parseLong(stringUserId);
//        boardService.create(userId, request);
        return ApiResponse.success(SuccessType.CREATE_BOARD_SUCCESS, userId);
    }

    @PostMapping("/test2")
    public ResponseEntity<?> login2(
            @UserId Long userId) {
        System.out.println("userId = " + userId);
        return ApiResponse.success(SuccessType.CREATE_BOARD_SUCCESS, userId);
    }

    /**
     * User Service
     *
     */
//    @Transactional
//    public Long login(UserLoginRequestDto request) {
//        User user = userRepository.findByEmail(request.getEmail())
//                .orElseThrow(() -> new NotFoundException(Error.NOT_FOUND_USER_EXCEPTION, Error.NOT_FOUND_USER_EXCEPTION.getMessage()));
//
//        if (!user.getPassword().equals(request.getPassword())) {
//            throw new BadRequestException(Error.INVALID_PASSWORD_EXCEPTION, Error.INVALID_PASSWORD_EXCEPTION.getMessage());
//        }
//
//        return user.getId();
//    }
}
