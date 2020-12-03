package com.api.auto.challenge.test;

import com.api.auto.challenge.data.Constants;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

public class WeatherTest extends BaseTest {

  @Test
  public void londonWeatherTest() {
    logger.info("TEST. London Weather Test");

    logger.info("STEP. Request weather information for London, UK");
    RestAssured.given()
        .baseUri(Constants.TestData.API_BASE_URI)
        .queryParam("appid", Constants.TestData.API_APP_ID)
        .queryParam("id", Constants.TestData.CITY_ID_LONDON_UK)
        .when()
        .get(Constants.TestData.WEATHER_PATH)
        .then()
        .assertThat()
        .statusCode(HttpStatus.SC_OK)
        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath(Constants.TestData.WEATHER_SCHEMA));
  }
}
