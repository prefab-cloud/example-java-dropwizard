package com.example.helloworld.resources;

import cloud.prefab.client.ConfigClient;
import com.example.helloworld.views.HomeView;
import com.google.inject.Inject;
import io.dropwizard.views.View;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public class HomeResource {

  private static final Logger LOGGER = LoggerFactory.getLogger(HomeResource.class);

  private final HomeView homeView;

  @Inject
  public HomeResource(ConfigClient configClient){
    this.homeView = new HomeView(configClient);
  }

  @GET
  @Produces("text/html;charset=UTF-8")
  public View freemarkerUTF8() {
    
    LOGGER.trace("trace level logging");
    LOGGER.debug("debug level logging");
    LOGGER.info("info level logging");
    LOGGER.warn("warn level logging");
    LOGGER.error("error level logging");



    return homeView;
  }
}
