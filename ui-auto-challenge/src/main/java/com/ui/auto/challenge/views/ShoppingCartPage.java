package com.ui.auto.challenge.views;

import com.ui.auto.challenge.utils.ComponentFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {

  @FindBy(css = "#cart_contents_container .cart_item")
  private List<WebElement> cartItems;

  @FindBy(linkText = "CHECKOUT")
  private WebElement checkoutButton;

  /**
   * Get total cart items count
   *
   * @return Integer
   */
  public Integer getTotalCartItemsCount() {
    return cartItems.size();
  }

  /**
   * Click on Checkout button
   *
   * @return CheckoutYourInformationPage
   */
  public CheckoutYourInformationPage clickCheckoutButton() {
    logger.info("Clicking on Checkout button");
    checkoutButton.click();
    return ComponentFactory.create(CheckoutYourInformationPage.class);
  }
}
