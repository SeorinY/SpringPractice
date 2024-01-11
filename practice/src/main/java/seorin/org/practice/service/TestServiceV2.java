package seorin.org.practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestServiceV2 {

	private final TestServiceV1 testServiceV1;
}
