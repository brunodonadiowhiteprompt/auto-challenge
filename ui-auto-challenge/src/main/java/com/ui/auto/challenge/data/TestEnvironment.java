package com.ui.auto.challenge.data;

public enum TestEnvironment {
  test("https://www.saucedemo.com");

  private String landingURL;

  TestEnvironment(String URL) {
    this.landingURL = URL;
  }

  public String getLandingURL() {
    return landingURL;
  }
}
