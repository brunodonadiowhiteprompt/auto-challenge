package com.ui.auto.challenge.helpers;

import org.openqa.selenium.WebElement;

public class WebHelper {

  /**
   * Check if element is displayed
   *
   * @param element
   * @return boolean
   */
  public static boolean isDisplayed(WebElement element) {
    try {
      return element.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
