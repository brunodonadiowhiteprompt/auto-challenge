package com.ui.auto.challenge.views;

import com.ui.auto.challenge.data.Constants;
import com.ui.auto.challenge.helpers.PurchaseHelper;
import com.ui.auto.challenge.helpers.WebHelper;
import com.ui.auto.challenge.utils.ComponentFactory;
import com.ui.auto.challenge.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {

  @FindBy(id = "header_container")
  private WebElement headerContainer;

  @FindBy(css = "#inventory_container .inventory_list .inventory_item")
  private List<WebElement> productsCards;

  private String productCardPath =
      "//div[@class='inventory_item_name'][contains(text(), '%s')]/ancestor::div[@class='inventory_item']";

  private By productNameLocator = By.cssSelector("div.inventory_item_name");

  private By productPriceLocator = By.cssSelector("div.inventory_item_price");

  private By productAddToCartLocator = By.cssSelector("button.btn_inventory");

  @FindBy(css = "#shopping_cart_container a.shopping_cart_link")
  private WebElement shoppingCartLink;

  @FindBy(css = "#shopping_cart_container span.shopping_cart_badge")
  private WebElement shoppingCartBadge;

  /**
   * Check if Header Container is displayed
   *
   * @return boolean
   */
  public boolean isHeaderContainerDisplayed() {
    logger.info("Checking if Header Container is displayed");
    return WebHelper.isDisplayed(headerContainer);
  }

  /**
   * Get products by name
   *
   * @param name
   * @return List<WebElement>
   */
  public List<WebElement> getProductsByName(String name) {
    return DriverManager.getDriver().findElements(By.xpath(String.format(productCardPath, name)));
  }

  /**
   * Get total T-Shirts count
   *
   * @return Integer
   */
  public Integer getTotalTShirtsCount() {
    return getProductsByName(Constants.TestData.PRODUCTS_T_SHIRT_KEYWORD).size();
  }

  /**
   * Get total T-Shirts price
   *
   * @return Double
   */
  public Double getTotalTShirtsPrice() {
    List<Double> TShirtsPrices = new ArrayList<Double>();
    getProductsByName("T-Shirt").stream()
        .forEach(
            product ->
                TShirtsPrices.add(
                    PurchaseHelper.parseProductPrice(
                        product.findElement(productPriceLocator).getText())));

    return TShirtsPrices.stream().mapToDouble(Double::doubleValue).sum();
  }

  /** Add all T-Shirts to cart */
  public void addAllTShirtsToCart() {
    getProductsByName("T-Shirt")
        .forEach(
            (productCard) -> {
              logger.info(
                  String.format(
                      "Adding product [%s] to shopping cart",
                      productCard.findElement(productNameLocator).getText()));
              productCard.findElement(productAddToCartLocator).click();
            });
  }

  /**
   * Click Shopping Cart link
   *
   * @return ShoppingCartPage
   */
  public ShoppingCartPage clickShoppingCartLink() {
    logger.info("Clicking on Shopping Cart link");
    shoppingCartLink.click();
    return ComponentFactory.create(ShoppingCartPage.class);
  }

  /**
   * Get Shopping Cart Badge value
   *
   * @return Integer
   */
  public Integer getShoppingCartBadgeValue() {
    return Integer.valueOf(shoppingCartBadge.getText());
  }
}
