package com.tek4tv.report;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;

@OpenAPIDefinition(
    info = @Info(
            title = "report_service",
            version = "0.0",
            contact = @Contact(name = "Tek4TV", email = "tek4tv@mail.com"),
            license = @License(name = "Tek4TV License")
    )
)
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
