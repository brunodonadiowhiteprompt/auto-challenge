package com.ui.auto.challenge.views;

import com.ui.auto.challenge.utils.ComponentFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutYourInformationPage extends BasePage {

  @FindBy(css = "input[data-test='firstName']")
  private WebElement firstNameField;

  @FindBy(css = "input[data-test='lastName']")
  private WebElement lastNameField;

  @FindBy(css = "input[data-test='postalCode']")
  private WebElement postalCodeField;

  @FindBy(css = ".checkout_buttons input.cart_button")
  private WebElement continueButton;

  /**
   * Fill First Name field
   *
   * @param firstName
   */
  public void fillFirstNameField(String firstName) {
    logger.info(String.format("Filling First Name field with [%s]", firstName));
    firstNameField.sendKeys(firstName);
  }

  /**
   * Fill Last Name field
   *
   * @param lastName
   */
  public void fillLastNameField(String lastName) {
    logger.info(String.format("Filling Last Name field with [%s]", lastName));
    lastNameField.sendKeys(lastName);
  }

  /**
   * Fill Postal Code field
   *
   * @param postalCode
   */
  public void fillPostalCodeField(String postalCode) {
    logger.info(String.format("Filling Postal Code field with [%s]", postalCode));
    postalCodeField.sendKeys(postalCode);
  }

  /**
   * Click Continue button
   *
   * @return CheckoutOverviewPage
   */
  public CheckoutOverviewPage clickContinueButton() {
    logger.info("Clicking on Continue button");
    continueButton.click();

    return ComponentFactory.create(CheckoutOverviewPage.class);
  }
}
