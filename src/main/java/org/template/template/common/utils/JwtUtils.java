package org.template.template.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.template.template.common.model.DefaultUserInfo;

import java.util.Base64;

public class JwtUtils {

    public static DefaultUserInfo parse(String token) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String[] chunks = token.split("\\.");
            Base64.Decoder decoder = Base64.getDecoder();

            String payload = new String(decoder.decode(chunks[1]));

            return objectMapper.readValue(payload, DefaultUserInfo.class);


        } catch (Exception e) {
            throw new RuntimeException("Failed to validate Authorization Token: " + e.getMessage());
        }
    }
}
