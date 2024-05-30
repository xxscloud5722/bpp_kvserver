package com.beer.api.environment;

import io.quarkus.runtime.StartupEvent;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.event.Observes;

/**
 * 静态资源.
 */
public class StaticResources {
    void installRoute(@Observes StartupEvent startupEvent, Router router) {
        router.route()
                .path("/static/*")
                .handler(StaticHandler.create("static/"));
    }
}
