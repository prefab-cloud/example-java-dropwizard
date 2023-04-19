package com.example.helloworld.filter;

import cloud.prefab.client.ConfigClient;
import cloud.prefab.context.PrefabContext;
import com.example.helloworld.core.User;
import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.SecurityContext;
import java.io.IOException;
import java.security.Principal;

public class PrefabContextAddingRequestFilter implements ContainerRequestFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrefabContextAddingRequestFilter.class);
    private final ConfigClient configClient;

    @Inject
    public PrefabContextAddingRequestFilter(ConfigClient configClient) {
        this.configClient = configClient;
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        final SecurityContext securityContext =
                containerRequestContext.getSecurityContext();
        if (securityContext != null) {
            Principal principal = securityContext.getUserPrincipal();
            if (principal instanceof User) {
                User user = (User) principal;
                LOGGER.info("will add pf context for {}", user);
                configClient.getContextStore().addContext(PrefabContext.newBuilder("User")
                        .put("name", user.getName())
                        .build());
            }

        }


    }
}
