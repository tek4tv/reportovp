package com.tek4tv.report.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import java.util.Date;

@Data
@Setter
@Getter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class Performance {
    private Long id;
    private String video;
    private String player;
    private String sourceOfTraffic;
    private String displayDomain;
    private String country;
    private String device;
    private String deviceType;
    private String deviceOs;
    private String deviceManufacturer;
    private String browserType;
    private Date day;
}
