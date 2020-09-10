package com.tek4tv.report.repository;

import com.tek4tv.report.entity.ReportEntity;

import java.util.Date;
import java.util.List;

public interface ReportRepositoryCustom {
    List<ReportEntity> getReportDetail(String video, String os, Date fromDate, Date toDate);
}
