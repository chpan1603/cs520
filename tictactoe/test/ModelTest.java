import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import Controllers.*;
import Models.*;
import Views.*;

/**
 * A model test class.
 * Test1 tests if click works.
 * Test2 tests if the right message shows.
 */
public class ModelTest {
    @Test
    public void testNewGame() {
    	//Initialize model
  	  	Positions positions = new Positions();

  	  	//Initialize views
  	  	MessageView textView = new MessageView();
  	  	ClickView clickView = new ClickView();
  	  	
  	  	/**********/
  	  	//Register views to models
  	  	positions.addObserver(textView);
  	  	positions.addObserver(clickView);
  	  	/**********/
  	  	
  	  	//Test1
  	  	//Check if the particular tile now shows 'X'
  	  	Integer pos = new Integer(1);
  	  	positions.addData(pos);
  	  	String str1 = "X";
  	  	assertEquals(str1, clickView.getButton()[1].getText());
  	  	
  	  	//Test2
  	  	//Check if the message shows "'O': Player 2"
  	  	String str2 = "'O': Player 2";
  	  	assertEquals(str2, textView.getMessage());
  	  	
    }
}
