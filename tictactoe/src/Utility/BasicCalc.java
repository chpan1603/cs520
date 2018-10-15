package Utility;

import java.util.*;

/**
 * A simple class to transform.
 */
public class BasicCalc {
	
	// Helper method
    public static int[] getArrayInteger(ArrayList<Integer> integers) {
          int[] result = new int[integers.size()];

          //O(n) iteration to convert result
          for (int i = 0 ; i < integers.size(); i++) {
              result[i] = integers.get(i);
          }

          return result;
    }

}


