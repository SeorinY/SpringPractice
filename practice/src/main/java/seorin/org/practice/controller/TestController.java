package seorin.org.practice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seorin.org.practice.controller.Http.ApiResponse;
import seorin.org.practice.controller.Http.SuccessType;
import seorin.org.practice.controller.dto.PostResponseDto;
import seorin.org.practice.controller.dto.PostTestRequest;
import seorin.org.practice.entity.TestEntity;
import seorin.org.practice.repository.TestRepository;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @PostMapping("/test")
    public ResponseEntity<?> postTest(@RequestBody PostTestRequest request) {
        testRepository.save(TestEntity.of(request.getContext()));
        PostResponseDto response = new PostResponseDto("post test");
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS, response);
    }

    @GetMapping("/test")
    public ResponseEntity<?> postTest() {
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS);
    }
}
