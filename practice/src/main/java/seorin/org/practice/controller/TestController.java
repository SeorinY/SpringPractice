package seorin.org.practice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import seorin.org.practice.http.ApiResponse;
import seorin.org.practice.http.SuccessType;
import seorin.org.practice.controller.dto.PostTestResponse;
import seorin.org.practice.controller.dto.PostTestRequest;
import seorin.org.practice.entity.TestEntity;
import seorin.org.practice.jwt.JwtService;
import seorin.org.practice.repository.TestRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
@Tag(name = "Tag name test", description = "Tag description test")
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



    @PostMapping("/swagger")
    @Operation(summary = "Operation summary test", description = "Operation description test")
    public ResponseEntity<?> testSwaggerPost(@RequestBody PostTestRequest request) {
        testRepository.save(TestEntity.of(request.getContext()));
        PostTestResponse response = new PostTestResponse("post test");
        return ApiResponse.success(SuccessType.LOGIN_SUCCESS, response);
    }
}
