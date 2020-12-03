package com.ui.auto.challenge.views;

import com.ui.auto.challenge.components.BaseComponent;
import com.ui.auto.challenge.data.Constants;
import com.ui.auto.challenge.utils.ComponentFactory;
import com.ui.auto.challenge.utils.DriverManager;

public class BasePage extends BaseComponent {

  /**
   * Navigate to Landing page
   *
   * @return ProductsPage
   */
  public <T extends BasePage> T navigateToLanding(Class<T> clazz) {
    logger.info("Navigating to landing page");
    DriverManager.getDriver().navigate().to(Constants.TestData.LANDING_PAGE_URL);

    return ComponentFactory.create(clazz);
  }
}
