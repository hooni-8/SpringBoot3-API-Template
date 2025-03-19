package org.template.template.service.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.template.template.mapper.v1.test.TestMapper;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestMapper testMapper;

    public String test(String userId) {
        return testMapper.getUserName(userId);
    }
}
