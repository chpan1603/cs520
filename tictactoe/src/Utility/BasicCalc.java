package Utility;



import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * A simple class to calculate moves.
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


