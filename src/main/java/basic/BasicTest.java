package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n){
    try{
        if( i<0 || n<0 )
        {
          return Option.none();
        }
        long result = 1;
        // running loop while the power > 0
        while (n != 0) 
        {
          result = result * i;
          // if result is out of range
          if(result>Integer.MAX_VALUE)
            {
              return Option.none();
            }
          n--;
        }
        Option<Integer> resOption = Option.of((int) (long)result);
        return resOption;
    } 
    catch(IndexOutOfBoundsException e){
      return Option.none();
    }
  }
}
