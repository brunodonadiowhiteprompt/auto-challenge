package com.api.auto.challenge.data;

public enum TestEnvironment {
  test("https://api.openweathermap.org/data/2.5");

  private String baseURI;

  TestEnvironment(String URI) {
    this.baseURI = URI;
  }

  public String getBaseURI() {
    return baseURI;
  }
}
