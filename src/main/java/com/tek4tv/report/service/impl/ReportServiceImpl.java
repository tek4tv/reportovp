package com.tek4tv.report.service.impl;

import com.tek4tv.report.entity.ReportEntity;
import com.tek4tv.report.repository.ReportRepository;
import com.tek4tv.report.service.ReportService;

import javax.inject.Inject;
import javax.transaction.Transactional;

public class ReportServiceImpl implements ReportService {

    @Inject
    ReportRepository repository;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReportEntity insertReport(ReportEntity reportEntity) {
        return repository.update(reportEntity);
    }
}