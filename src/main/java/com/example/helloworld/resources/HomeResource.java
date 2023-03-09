package com.example.helloworld.resources;

import com.example.helloworld.views.HomeView;
import io.dropwizard.views.View;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.nio.charset.StandardCharsets;

@Path("/")
public class HomeResource {
  @GET
  @Produces("text/html;charset=UTF-8")
  public View freemarkerUTF8() {
    return new HomeView();
  }
}
