package seorin.org.practice2.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Schema(description = "Test Dto")
public class PostTestRequest {

    @Schema(description = "아무 context")
    private String context;

}
