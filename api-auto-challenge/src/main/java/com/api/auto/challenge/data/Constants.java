package com.api.auto.challenge.data;

import com.api.auto.challenge.helpers.TestHelper;

public class Constants {

  public static final class TestData {

    /** API Key **/
    public static final String API_APP_ID = "03cbbb27be18fb6149978b67662d2fc5";

    /** API Paths */
    public static final String API_BASE_URI =
        TestEnvironment.valueOf(TestHelper.getEnvironment()).getBaseURI();
    public static final String WEATHER_PATH = "/weather";

    /** Cities **/
    public static final String CITY_ID_LONDON_UK = "2643743";

    /** Schemas **/
    public static final String WEATHER_SCHEMA = "weather-schema.json";
  }
}
