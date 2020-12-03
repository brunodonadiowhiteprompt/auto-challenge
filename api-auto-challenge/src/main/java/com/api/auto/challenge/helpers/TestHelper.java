package com.api.auto.challenge.helpers;

public class TestHelper {

  /**
   * Get current execution environment
   *
   * @return String the environment
   */
  public static String getEnvironment() {
    return System.getProperty("env", "test");
  }
}
