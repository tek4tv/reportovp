package com.tek4tv.report.service;

import com.tek4tv.report.domain.Aggregation;
import com.tek4tv.report.entity.ReportEntity;

import javax.inject.Singleton;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Singleton
public interface ReportService {
    ReportEntity insertReport(ReportEntity reportEntity);
    Set<Aggregation> aggregationByOs(Date fromDate, Date toDate);
    Set<Aggregation> aggregationByVideo(Date fromDate, Date toDate);
    Set<Aggregation> aggregationViewAndDurationByVideo(Date fromDate, Date toDate);
    List<ReportEntity> findReportDetail(String video, String os, Date fromDate, Date toDate);
}
