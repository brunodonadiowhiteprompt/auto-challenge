package com.ui.auto.challenge.components;

import com.ui.auto.challenge.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseComponent {

  protected static final Logger logger = LogManager.getLogger();

  /** BaseComponent constructor */
  public BaseComponent() {
    PageFactory.initElements(DriverManager.getDriver(), this);
  }
}
