package com.example.helloworld.views;

import com.example.helloworld.core.Person;
import io.dropwizard.views.View;

public class HomeView extends View {

  public HomeView() {
    super("freemarker/home.ftl");
  }

  public String getPerson() {
    return "Hello World!";
  }
}
