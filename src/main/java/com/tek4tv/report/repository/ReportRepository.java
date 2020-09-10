package com.tek4tv.report.repository;

import com.tek4tv.report.entity.ReportEntity;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Long> {

    @Query(value = "select new ReportEntity(deviceOs, count(1)) from ReportEntity where insertDatetime >= :fromDate and insertDatetime <= :toDate group by deviceOs")
    List<ReportEntity> aggregationByOs(Date fromDate, Date toDate);

    @Query(value = "select new ReportEntity(video||'-'||videoName, count(1)) from ReportEntity where insertDatetime >= :fromDate and insertDatetime <= :toDate group by video||'-'||videoName")
    List<ReportEntity> aggregationByVideo(Date fromDate, Date toDate);

    @Query(value = "select new ReportEntity(video||'-'||videoName, sum(videoView), avg(videoDuration)) from ReportEntity where insertDatetime >= :fromDate and insertDatetime <= :toDate group by video||'-'||videoName")
    List<ReportEntity> aggregationViewAndDurationByVideo(Date fromDate, Date toDate);
}
