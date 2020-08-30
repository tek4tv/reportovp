package com.tek4tv.report.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Single;

@Client(value = "${ovp.url}")
public abstract class OVPClient {
    @Get("/authority/{token}")
    public abstract Single<Boolean> verifyToken(@PathVariable(value = "token") String token);
}
