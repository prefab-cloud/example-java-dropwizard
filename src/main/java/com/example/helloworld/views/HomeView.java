package com.example.helloworld.views;

import cloud.prefab.client.ConfigClient;
import io.dropwizard.views.View;

import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

public class HomeView extends View {

  private Supplier<String> sampleString;
  private Supplier<Long> sampleLong;

  public HomeView(ConfigClient configClient) {
    super("home.ftl", StandardCharsets.UTF_8);
    this.sampleString = configClient.liveString("sample.string");
    this.sampleLong = configClient.liveLong("sample.long");
  }

  public String getPerson() {
    return "Hello World!";
  }

  public String getSampleString() {
    return sampleString.get();
  }

  public Long getSampleLong() {
    return sampleLong.get();
  }

  public boolean getFeatureFlag() {
    return true;
  }
}
