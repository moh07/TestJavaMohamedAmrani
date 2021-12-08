package collection;

import java.util.List;
import basic.BasicTest;
import java.util.ArrayList;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */
  public static List<Double> compute1(List<Integer> input) {
    BasicTest basicTest=new BasicTest();
    List<Double> result = new ArrayList<>();
    // I used the function of basicTest
    for (Integer i : input) {
      result.add(Double.valueOf(basicTest.power(((i*2)+3),5).get()));
		}
    return result;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    List<String> result = new ArrayList<>();
    for (String i : input) {
      result.add(capitalize(i) + capitalize(i));
		}
    return result;
  }

  public static String capitalize(String str) {
    if(str == null || str.isEmpty()) {
        return str;
    }
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

}
