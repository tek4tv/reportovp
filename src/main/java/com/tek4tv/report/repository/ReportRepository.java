package com.tek4tv.report.repository;

import com.tek4tv.report.entity.ReportEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
