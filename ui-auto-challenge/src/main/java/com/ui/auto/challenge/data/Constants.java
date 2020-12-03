package com.ui.auto.challenge.data;

import com.ui.auto.challenge.helpers.TestHelper;

public class Constants {

  public static final class TestData {

    /** Pages */
    public static final String LANDING_PAGE_URL =
        TestEnvironment.valueOf(TestHelper.getEnvironment()).getLandingURL();

    /** Login */
    public static final String LOGIN_STANDARD_USER_USERNAME = "standard_user";
    public static final String LOGIN_STANDARD_USER_PASSWORD = "secret_sauce";

    /** Checkout Your Information */
    public static final String CHECKOUT_YOUR_INFORMATION_FIRST_NAME = "John";
    public static final String CHECKOUT_YOUR_INFORMATION_LAST_NAME = "Bryant";
    public static final String CHECKOUT_YOUR_INFORMATION_POSTAL_CODE = "10016";
  }
}
