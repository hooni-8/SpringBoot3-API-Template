package org.template.template.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DefaultUserInfo {

    private String userName;

    private String userCode;

    private String role;
}
