package org.template.template.controller.v1.test;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.template.template.common.model.DefaultUserInfo;
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
    public ResponseEntity<String> test(@Parameter(hidden = true) @AuthenticationPrincipal DefaultUserInfo userInfo, @RequestBody TestRequest testRequest) {
        log.info("userInfo => {}", userInfo.getUserCode());
        log.info("userInfo => {}", userInfo.getUserName());
        log.info("userInfo => {}", userInfo.getRole());

//        log.info("testRequest => {}", testRequest.getUserId());
        String result = testService.test(testRequest.getUserId());
//        log.info("result => {}", result);
        return ResponseEntity.ok(userInfo.getUserCode());
    }
}
