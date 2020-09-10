package com.tek4tv.report.repository.impl;

import com.tek4tv.report.entity.ReportEntity;
import com.tek4tv.report.repository.ReportRepositoryCustom;
import io.micronaut.core.util.StringUtils;
import io.micronaut.data.annotation.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepositoryCustomImpl implements ReportRepositoryCustom {
    @PersistenceContext
    private final EntityManager entityManager;

    public ReportRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<ReportEntity> getReportDetail(String video, String os, Date fromDate, Date toDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("fromDate", fromDate);
        params.put("toDate", toDate);
        String sql = "select r from ReportEntity r where r.insertDatetime >= :fromDate and r.insertDatetime <= :toDate";
        if (StringUtils.isNotEmpty(video)) {
            sql += " and r.video = :video";
            params.put("video", video);
        }
        if (StringUtils.isNotEmpty(os)) {
            sql += " and r.deviceOs =: os";
            params.put("os", os);
        }
        Query query = entityManager.createQuery(sql);
        params.forEach(query::setParameter);

        return query.getResultList();
    }
}
