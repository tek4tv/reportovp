package com.tek4tv.report.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.core.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class TokenUtil {

    private TokenUtil() {}

    public static String getAccountFromToken(String token) {
        if (StringUtils.isNotEmpty(token)) {
            try {
                String[] temp = token.split("\\.", 3);
                if (temp.length == 3) {
                    String payload = new String(Base64.getDecoder().decode(temp[1]), StandardCharsets.UTF_8);
                    if (StringUtils.isNotEmpty(payload)) {
                        return new ObjectMapper().readTree(payload).get("unique_name").textValue();
                    }
                }
            } catch (Exception ex) {
                log.warn(ex.getMessage(), ex);
            }
        }
        return "";
    }
}
