package seorin.org.practice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seorin.org.practice.Http.ApiResponse;
import seorin.org.practice.Http.SuccessType;
import seorin.org.practice.controller.dto.LoginTestRequest;
import seorin.org.practice.controller.dto.PostTestResponse;
import seorin.org.practice.controller.dto.PostTestRequest;
import seorin.org.practice.entity.TestEntity;
import seorin.org.practice.jwt.JwtService;
import seorin.org.practice.repository.TestRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final JwtService jwtService;
    private final TestRepository testRepository;

    @PostMapping
    public ResponseEntity<?> postTest(@RequestBody PostTestRequest request) {
        testRepository.save(TestEntity.of(request.getContext()));
        PostTestResponse response = new PostTestResponse("post test");
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS, response);
    }

    @GetMapping
    public ResponseEntity<?> postTest() {
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS);
    }
}
