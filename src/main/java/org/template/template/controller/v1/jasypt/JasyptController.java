package org.template.template.controller.v1.jasypt;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.template.template.controller.v1.BaseV1Controller;
import org.template.template.service.v1.jasypt.JasyptService;

@Slf4j
@Tag(name = "1 Jasypt", description = "Jasypt")
@RestController
@RequestMapping("/Jasypt")
@RequiredArgsConstructor
public class JasyptController extends BaseV1Controller {

    private final JasyptService jasyptService;

    @GetMapping("/encrypt")
    public String encrypt(String key, String content) {
        return jasyptService.encrypt(key, content);
    }

    @GetMapping("/decrypt")
    public String decrypt(String key, String content) {
        return jasyptService.decrypt(key, content);
    }

}
