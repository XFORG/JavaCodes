//: enumerated/menu/Course.java
package com.xforg.enumerated.menu;
import com.xforg.utils.Enums;

public enum Course {
  APPETIZER(Food.Appetizer.class),
  MAINCOURSE(Food.MainCourse.class),
  DESSERT(Food.Dessert.class),
  COFFEE(Food.Coffee.class);
  private Food[] values;
  private Course(Class<? extends Food> kind) {
    values = kind.getEnumConstants();/*获取每个Food子类的所有enum实例，这些实例在randomSelection中被调用*/
  }
  public Food randomSelection() {
    return Enums.random(values);
  }
} ///:~
