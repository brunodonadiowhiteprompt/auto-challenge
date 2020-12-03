package com.ui.auto.challenge.views;

import com.ui.auto.challenge.helpers.PurchaseHelper;
import com.ui.auto.challenge.utils.ComponentFactory;
import com.ui.auto.challenge.components.BaseComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

  @FindBy(css = "#checkout_summary_container .summary_info div.summary_subtotal_label")
  private WebElement orderSubtotalContainer;

  @FindBy(linkText = "FINISH")
  private WebElement finishButton;

  /**
   * Click Finish button
   *
   * @return CheckoutCompletePage
   */
  public CheckoutCompletePage clickFinishButton() {
    BaseComponent.logger.info("Clicking on Finish button");
    finishButton.click();

    return ComponentFactory.create(CheckoutCompletePage.class);
  }

  /**
   * Get Order Subtotal
   *
   * @return Double
   */
  public Double getOrderSubtotal() {
    return PurchaseHelper.parseOrderSubtotal(orderSubtotalContainer.getText());
  }
}
