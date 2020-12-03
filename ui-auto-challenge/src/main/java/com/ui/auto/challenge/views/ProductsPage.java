package com.ui.auto.challenge.views;

import com.ui.auto.challenge.helpers.PurchaseHelper;
import com.ui.auto.challenge.helpers.WebHelper;
import com.ui.auto.challenge.utils.ComponentFactory;
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
   * Get total products count
   *
   * @return Integer
   */
  public Integer getTotalProductsCount() {
    return productsCards.size();
  }

  /**
   * Get total products price
   *
   * @return Double
   */
  public Double getTotalProductsPrice() {
    List<Double> totalProductsPrice = new ArrayList<Double>();
    productsCards.stream()
        .forEach(
            productCard ->
                totalProductsPrice.add(
                    PurchaseHelper.parseProductPrice(
                        productCard.findElement(productPriceLocator).getText())));

    return totalProductsPrice.stream().mapToDouble(f -> f.doubleValue()).sum();
  }

  /** Add all products to cart */
  public void addAllProductsToCart() {
    productsCards.forEach(
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
