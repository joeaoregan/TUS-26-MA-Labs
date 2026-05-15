package com.tus.gatewayserver.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Order(1)
@Component
public class RequestTraceFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(RequestTraceFilter.class);

    @Autowired
    FilterUtility filterUtility;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String correlationId = filterUtility.getCorrelationId(exchange.getRequest().getHeaders());
        if (correlationId != null) {
            logger.debug("tusbank-correlation-id found in the incoming request: {}. ", correlationId);
        } else {
            correlationId = generateCorrelationId();
            logger.debug("tusbank-correlation-id generated: {}.", correlationId);
        }

        exchange = filterUtility.setCorrelationId(exchange, correlationId);
        return chain.filter(exchange);
    }

    private String generateCorrelationId() {
        return java.util.UUID.randomUUID().toString();
    }
}
