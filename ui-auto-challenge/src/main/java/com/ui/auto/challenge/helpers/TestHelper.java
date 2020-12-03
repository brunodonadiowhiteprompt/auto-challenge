package com.ui.auto.challenge.helpers;

public class TestHelper {

  /**
   * Get current execution environment
   *
   * @return String the environment
   */
  public static String getEnvironment() {
    return System.getProperty("env", "dev");
  }

  /**
   * Get current execution driver
   *
   * @return String the driver
   */
  public static String getDriver() {
    return System.getProperty("driver");
  }
}
