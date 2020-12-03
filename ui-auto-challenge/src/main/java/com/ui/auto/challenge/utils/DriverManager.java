package com.ui.auto.challenge.utils;

import com.ui.auto.challenge.helpers.SyncHelper;
import com.ui.auto.challenge.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

  private static final Logger logger = LogManager.getLogger();
  private static WebDriver driver;

  /** Initialize webdriver instance */
  public static void init() {
    if (driver == null) {
      logger.info("Initializing webdriver instance");
      switch (TestHelper.getDriver()) {
        case "chrome":
          driver = new ChromeDriver();
          break;
        case "safari":
          driver = new SafariDriver();
          break;
        case "firefox":
          driver = new FirefoxDriver();
          break;
        case "edge":
          driver = new EdgeDriver();
          break;
        case "opera":
          driver = new OperaDriver();
          break;
        default:
          throw new IllegalArgumentException("Provided driver is invalid");
      }
      SyncHelper.setDriverTimeout(SyncHelper.driverTimeout);
      driver.manage().window().maximize();
    }
  }

  /** End webdriver instance */
  public static void exit() {
    logger.info("Stopping webdriver instance");
    driver.quit();
    driver = null;
  }

  /**
   * Get webdriver instance
   *
   * @return driver
   */
  public static WebDriver getDriver() {
    return driver;
  }
}
