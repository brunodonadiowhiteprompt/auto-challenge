package com.ui.auto.challenge.test;

import com.ui.auto.challenge.utils.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected static final Logger logger = LogManager.getLogger();

  @BeforeTest
  public void beforeTest() {
    DriverManager.init();
  }

  @AfterTest
  public void afterTest() {
    DriverManager.exit();
  }
}
