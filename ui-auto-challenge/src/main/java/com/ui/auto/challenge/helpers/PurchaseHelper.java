package com.ui.auto.challenge.helpers;

public class PurchaseHelper {

  public static Double parseProductPrice(String price) {
    return Double.valueOf(price.replace("$", ""));
  }

  public static Double parseOrderSubtotal(String orderSubtotal) {
    return Double.valueOf(orderSubtotal.replace("Item total: $", ""));
  }
}
