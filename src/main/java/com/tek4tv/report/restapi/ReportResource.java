package com.tek4tv.report.restapi;

import com.tek4tv.report.client.OVPClient;
import com.tek4tv.report.entity.ReportEntity;
import com.tek4tv.report.service.ReportService;
import com.tek4tv.report.utils.Const;
import com.tek4tv.report.utils.TokenUtil;
import io.micronaut.context.annotation.Requires;
import io.micronaut.core.util.StringUtils;
import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Objects;

@Controller("/report")
@Validated
@Slf4j
public class ReportResource {

    @Inject
    OVPClient ovpClient;

    @Inject
    ReportService reportService;

    @Post(produces= MediaType.APPLICATION_JSON)
    @Operation(summary = "Put new report records",
            description = "Put new report records"
    )
    @ApiResponse(
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @ApiResponse(responseCode = "201", description = "Put successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Tag(name = "Performance APIs")
    public Single<MutableHttpResponse> post(@Header(HttpHeaders.AUTHORIZATION) String authorization, @Body @NotNull ReportEntity reportEntity) {
        return ovpClient.verifyToken(authorization).flatMap(isVerified -> {
            if (isVerified) {
                // get account from access token
                reportEntity.setAccount(TokenUtil.getAccountFromToken(authorization));
                return Single.just(HttpResponse.created(reportService.insertReport(reportEntity)));
            } else {
                return Single.just(HttpResponse.unauthorized());
            }
        });
    }

    @Get(uri = "/aggregationByOs", produces= MediaType.APPLICATION_JSON)
    @Operation(summary = "Aggregation by device os",
            description = "Aggregation by device os"
    )
    @ApiResponse(
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @ApiResponse(responseCode = "200", description = "Get report successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Tag(name = "Performance APIs")
    public Single<MutableHttpResponse> aggregationByOs(@Header(HttpHeaders.AUTHORIZATION) String authorization, @Parameter(name = "fromDate (format: dd-MM-yyyy)", required = true) @QueryValue("fromDate") String strFromDate, @Parameter(name = "toDate (format: dd-MM-yyyy)", required = true) @QueryValue("toDate") String strToDate){
        return ovpClient.verifyToken(authorization).flatMap(isVerified -> {
            if (isVerified) {
                Date fromDate = null;
                Date toDate = null;
                try {
                    if (StringUtils.isNotEmpty(strFromDate) && StringUtils.isNotEmpty(strToDate)) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        fromDate = format.parse(strFromDate);
                        toDate = format.parse(strToDate);
                    }
                } catch (Exception ex) {
                    log.warn(ex.getMessage());
                }
                if (Objects.isNull(fromDate) || Objects.isNull(toDate) || ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) > Const.DATE_BETWEEN_DEFAULT) {
                    return Single.just(HttpResponse.badRequest("Invalid input"));
                } else {
                    return Single.just(HttpResponse.ok(reportService.aggregationByOs(fromDate, toDate)));
                }
            } else {
                return Single.just(HttpResponse.unauthorized());
            }
        });
    }

    @Get(uri = "/aggregationByVideo", produces= MediaType.APPLICATION_JSON)
    @Operation(summary = "Aggregation by video name",
            description = "Aggregation by video name"
    )
    @ApiResponse(
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @ApiResponse(responseCode = "200", description = "Get report successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Tag(name = "Performance APIs")
    public Single<MutableHttpResponse> aggregationByVideo(@Header(HttpHeaders.AUTHORIZATION) String authorization, @Parameter(name = "fromDate (format: dd-MM-yyyy)", required = true) @QueryValue("fromDate") String strFromDate, @Parameter(name = "toDate (format: dd-MM-yyyy)", required = true) @QueryValue("toDate") String strToDate){
        return ovpClient.verifyToken(authorization).flatMap(isVerified -> {
            if (isVerified) {
                Date fromDate = null;
                Date toDate = null;
                try {
                    if (StringUtils.isNotEmpty(strFromDate) && StringUtils.isNotEmpty(strToDate)) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        fromDate = format.parse(strFromDate);
                        toDate = format.parse(strToDate);
                    }
                } catch (Exception ex) {
                    log.warn(ex.getMessage());
                }
                if (Objects.isNull(fromDate) || Objects.isNull(toDate) || ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) > Const.DATE_BETWEEN_DEFAULT) {
                    return Single.just(HttpResponse.badRequest("Invalid input"));
                } else {
                    return Single.just(HttpResponse.ok(reportService.aggregationByVideo(fromDate, toDate)));
                }
            } else {
                return Single.just(HttpResponse.unauthorized());
            }
        });
    }

    @Get(uri = "/aggregationViewAndDurationByVideo", produces= MediaType.APPLICATION_JSON)
    @Operation(summary = "Sum video view and Avg video duration by video name",
            description = "Sum video view and Avg video duration by video name"
    )
    @ApiResponse(
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @ApiResponse(responseCode = "200", description = "Get report successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Tag(name = "Performance APIs")
    public Single<MutableHttpResponse> aggregationViewAndDurationByVideo(@Header(HttpHeaders.AUTHORIZATION) String authorization, @Parameter(name = "fromDate (format: dd-MM-yyyy)", required = true) @QueryValue("fromDate") String strFromDate, @Parameter(name = "toDate (format: dd-MM-yyyy)", required = true) @QueryValue("toDate") String strToDate){
        return ovpClient.verifyToken(authorization).flatMap(isVerified -> {
            if (isVerified) {
                Date fromDate = null;
                Date toDate = null;
                try {
                    if (StringUtils.isNotEmpty(strFromDate) && StringUtils.isNotEmpty(strToDate)) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        fromDate = format.parse(strFromDate);
                        toDate = format.parse(strToDate);
                    }
                } catch (Exception ex) {
                    log.warn(ex.getMessage());
                }
                if (Objects.isNull(fromDate) || Objects.isNull(toDate) || ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) > Const.DATE_BETWEEN_DEFAULT) {
                    return Single.just(HttpResponse.badRequest("Invalid input"));
                } else {
                    return Single.just(HttpResponse.ok(reportService.aggregationViewAndDurationByVideo(fromDate, toDate)));
                }
            } else {
                return Single.just(HttpResponse.unauthorized());
            }
        });
    }

    @Get(uri = "/getReportDetail", produces= MediaType.APPLICATION_JSON)
    @Operation(summary = "Get list report detail by fromDate, toDate, video or device os",
            description = "Get list report detail by fromDate, toDate, video or device os"
    )
    @ApiResponse(
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @ApiResponse(responseCode = "200", description = "Get report successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @Tag(name = "Performance APIs")
    public Single<MutableHttpResponse> getReportDetail(@Header(HttpHeaders.AUTHORIZATION) String authorization,
                                                       @Parameter(name = "video id", required = false) @QueryValue("videoId") @Nullable String videoId,
                                                       @Parameter(name = "device os", required = false) @QueryValue("deviceOs") @Nullable String deviceOs,
                                                       @Parameter(name = "fromDate (format: dd-MM-yyyy)", required = true) @QueryValue("fromDate") String strFromDate,
                                                       @Parameter(name = "toDate (format: dd-MM-yyyy)", required = true) @QueryValue("toDate") String strToDate){
        return ovpClient.verifyToken(authorization).flatMap(isVerified -> {
            if (isVerified) {
                Date fromDate = null;
                Date toDate = null;
                try {
                    if (StringUtils.isNotEmpty(strFromDate) && StringUtils.isNotEmpty(strToDate)) {
                        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                        fromDate = format.parse(strFromDate);
                        toDate = format.parse(strToDate);
                    }
                } catch (Exception ex) {
                    log.warn(ex.getMessage());
                }
                if (Objects.isNull(fromDate) || Objects.isNull(toDate) || ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) > Const.DATE_BETWEEN_DEFAULT) {
                    return Single.just(HttpResponse.badRequest("Invalid input"));
                } else {
                    return Single.just(HttpResponse.ok(reportService.findReportDetail(videoId, deviceOs, fromDate, toDate)));
                }
            } else {
                return Single.just(HttpResponse.unauthorized());
            }
        });
    }
}
