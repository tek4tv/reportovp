package com.tek4tv.report.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aggregation {
    private String label;
    private Long count;
    private Long sumOfView;
    private Double avgOfDuration;
}
