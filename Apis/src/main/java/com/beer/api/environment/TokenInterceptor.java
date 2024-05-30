package com.beer.api.environment;

import jakarta.inject.Singleton;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Objects;

@Provider
@Singleton
public class TokenInterceptor implements ContainerRequestFilter {
    private static final String TOKEN_PARAMETER = "token";

    @ConfigProperty(name = "beer.token",defaultValue = "54e23552b007adf95506be46ee25defb")
    String authToken;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        final MultivaluedMap<String, String> queryParams = requestContext.getUriInfo().getQueryParameters();
        final String token = queryParams.getFirst(TOKEN_PARAMETER);
        if (StringUtils.isBlank(token)) {
            throw new WebApplicationException("Missing token", Response.Status.UNAUTHORIZED);
        }
        if (!Objects.equals(token, authToken)) {
            throw new WebApplicationException("Missing token", Response.Status.UNAUTHORIZED);
        }
    }
}
