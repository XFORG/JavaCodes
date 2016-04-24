//: enumerated/menu/Meal.java
package com.xforg.enumerated.menu;

public class Meal {
  public static void main(String[] args) {
    for(int i = 0; i < 9; i++) {
      for(Course course : Course.values()) {/*通过遍历每一个Course实例来获得“枚举的枚举”的值*/
        Food food = course.randomSelection();
        System.out.println(food);
      }
      System.out.println("---");
    }
  }
} /* Output:
SPRING_ROLLS
VINDALOO
FRUIT
DECAF_COFFEE
---
SOUP
VINDALOO
FRUIT
TEA
---
SALAD
BURRITO
FRUIT
TEA
---
SALAD
BURRITO
CREME_CARAMEL
LATTE
---
SOUP
BURRITO
TIRAMISU
ESPRESSO
---
*///:~
