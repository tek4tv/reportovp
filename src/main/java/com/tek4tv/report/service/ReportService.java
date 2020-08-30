package com.tek4tv.report.service;

import com.tek4tv.report.entity.ReportEntity;

import javax.inject.Singleton;

@Singleton
public interface ReportService {
    ReportEntity insertReport(ReportEntity reportEntity);
}
