package org.template.template.controller.v1.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.template.template.controller.v1.BaseV1Controller;
import org.template.template.service.v1.TestService;
import org.template.template.test.v1.TestRequest;

@Slf4j
@Tag(name = "Test", description = "Test API")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController extends BaseV1Controller {

    private final TestService testService;

    @Operation(summary = "유저 name 조회", description = "유저 name 조회")
    @PostMapping("/user")
    public String test(@RequestBody TestRequest testRequest) {

        return testService.test(testRequest.getUserId());
    }
}
