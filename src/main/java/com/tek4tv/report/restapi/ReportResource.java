package com.tek4tv.report.restapi;

import com.tek4tv.report.client.OVPClient;
import com.tek4tv.report.entity.ReportEntity;
import com.tek4tv.report.service.ReportService;
import com.tek4tv.report.utils.TokenUtil;
import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

@Controller("/report")
@Validated
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
}
