package seorin.org.practice2.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seorin.org.practice2.controller.dto.PostTestRequest;
import seorin.org.practice2.controller.dto.PostTestResponse;
import seorin.org.practice2.entity.TestEntity;
import seorin.org.practice2.http.ApiResponse;
import seorin.org.practice2.http.SuccessType;
import seorin.org.practice2.jwt.JwtService;
import seorin.org.practice2.repository.TestRepository;

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
