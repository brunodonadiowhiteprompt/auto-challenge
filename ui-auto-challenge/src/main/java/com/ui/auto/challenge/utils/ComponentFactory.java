package com.ui.auto.challenge.utils;

import com.ui.auto.challenge.components.BaseComponent;

public class ComponentFactory {

  /**
   * Initialize a new instance of a component
   *
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T extends BaseComponent> T create(Class<T> clazz) {
    try {
      return clazz.newInstance();
    } catch (Exception e) {
      throw new Error(e);
    }
  }
}
