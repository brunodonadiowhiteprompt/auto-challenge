package com.ui.auto.challenge.helpers;

import com.ui.auto.challenge.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SyncHelper {

  public static Duration driverTimeout = Duration.ofSeconds(30);

  public static WebDriverWait wait =
      new WebDriverWait(DriverManager.getDriver(), driverTimeout.getSeconds());

  /**
   * Explicit wait
   *
   * @param millis wait time in milliseconds
   */
  public static void wait(int millis) {
    try {
      synchronized (DriverManager.getDriver()) {
        DriverManager.getDriver().wait(millis);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Wait for an element to be visible
   *
   * @param element
   */
  public static void waitForVisibilityOfElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
  }

  /**
   * Wait for an element to disappear
   *
   * @param element
   */
  public static void waitForInvisibilityOfElement(WebElement element) {
    wait.until(ExpectedConditions.invisibilityOf(element));
  }

  /**
   * Set the implicit timeout value
   *
   * @param duration timeout time
   */
  public static void setDriverTimeout(Duration duration) {
    driverTimeout = duration;
    DriverManager.getDriver()
        .manage()
        .timeouts()
        .implicitlyWait(driverTimeout.toMillis(), TimeUnit.MILLISECONDS)
        .pageLoadTimeout(driverTimeout.toMillis(), TimeUnit.MILLISECONDS)
        .setScriptTimeout(driverTimeout.toMillis(), TimeUnit.MILLISECONDS);
  }
}
