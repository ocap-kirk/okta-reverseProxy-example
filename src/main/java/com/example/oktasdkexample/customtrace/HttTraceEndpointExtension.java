package com.example.oktasdkexample.customtrace;

import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.boot.actuate.trace.http.HttpTraceEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = HttpTraceEndpoint.class)
@ConditionalOnProperty(prefix = "management.trace.http", name = "enabled", matchIfMissing = true)
public class HttTraceEndpointExtension {

    private CustomHttpTraceRepository repository;
        
    public HttTraceEndpointExtension(CustomHttpTraceRepository repository) {
        super();
        this.repository = repository;
    }

    @ReadOperation
    public ContentTraceDescriptor contents() {
        List<ContentTrace> traces = repository.findAllWithContent();
        return new ContentTraceDescriptor(traces);
    }
}
