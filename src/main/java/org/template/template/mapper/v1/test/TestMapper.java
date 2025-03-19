package org.template.template.mapper.v1.test;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {
    String getUserName(String userId);
}
