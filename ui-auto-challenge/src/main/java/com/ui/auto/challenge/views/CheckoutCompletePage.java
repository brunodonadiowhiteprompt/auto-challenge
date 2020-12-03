package com.ui.auto.challenge.views;

import com.ui.auto.challenge.helpers.WebHelper;
import com.ui.auto.challenge.components.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

  @FindBy(css = "#checkout_complete_container .complete-text")
  private WebElement orderConfirmationContainer;

  /**
   * Check if Order Confirmation Container is displayed
   *
   * @return boolean
   */
  public boolean isOrderConfirmationContainerDisplayed() {
    BaseComponent.logger.info("Checking if Order Confirmation Container is displayed");
    return WebHelper.isDisplayed(orderConfirmationContainer);
  }
}
