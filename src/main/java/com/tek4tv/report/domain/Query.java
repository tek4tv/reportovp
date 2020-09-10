package com.tek4tv.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    private Set<String> queryFields;
    private Set<Filter> filters;
}
