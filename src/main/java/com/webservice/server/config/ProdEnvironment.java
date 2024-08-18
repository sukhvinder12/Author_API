package com.webservice.server.config;

import com.webservice.server.interfaces.AppEnvironment;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdEnvironment implements AppEnvironment {
    @Override
    public String name() {
        return "prod";
    }
}
