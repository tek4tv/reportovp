package com.tek4tv.report.service.impl;

import com.tek4tv.report.domain.Aggregation;
import com.tek4tv.report.entity.ReportEntity;
import com.tek4tv.report.repository.ReportRepository;
import com.tek4tv.report.repository.ReportRepositoryCustom;
import com.tek4tv.report.service.ReportService;
import io.micronaut.core.util.CollectionUtils;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Inject
    ReportRepository repository;
    @Inject
    ReportRepositoryCustom reportRepositoryCustom;

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ReportEntity insertReport(ReportEntity reportEntity) {
        return repository.update(reportEntity);
    }

    @Override
    public Set<Aggregation> aggregationByOs(Date fromDate, Date toDate) {
        List<ReportEntity> result = repository.aggregationByOs(fromDate, toDate);
        if (CollectionUtils.isNotEmpty(result)) {
            return result.stream().map(reportEntity -> Aggregation.builder().label(reportEntity.getLabel()).count(reportEntity.getCount()).build()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    @Override
    public Set<Aggregation> aggregationByVideo(Date fromDate, Date toDate) {
        List<ReportEntity> result = repository.aggregationByVideo(fromDate, toDate);
        if (CollectionUtils.isNotEmpty(result)) {
            return result.stream().map(reportEntity -> Aggregation.builder().label(reportEntity.getLabel()).count(reportEntity.getCount()).build()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    @Override
    public Set<Aggregation> aggregationViewAndDurationByVideo(Date fromDate, Date toDate) {
        List<ReportEntity> result = repository.aggregationViewAndDurationByVideo(fromDate, toDate);
        if (CollectionUtils.isNotEmpty(result)) {
            return result.stream().map(reportEntity -> Aggregation.builder().label(reportEntity.getLabel()).sumOfView(reportEntity.getSumOfView()).avgOfDuration(reportEntity.getAvgOfDuration()).build()).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }

    @Override
    public List<ReportEntity> findReportDetail(String video, String os, Date fromDate, Date toDate) {
        return reportRepositoryCustom.getReportDetail(video, os, fromDate, toDate);
    }
}