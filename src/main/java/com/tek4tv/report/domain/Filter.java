package com.tek4tv.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filter {
    private String field;
    private String operator;
    private Set<String> values;
    private String value;
    private String fromValue;
    private String toValue;
}
