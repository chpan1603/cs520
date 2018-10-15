import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import Controllers.*;
import Models.*;
import Views.*;

/**
 * A view test class.
 * Test1 tests ClickView.
 * Test2 tests ResetView.
 */
public class ViewTest {
    @Test
    public void testNewGame() {
    	//Initialize views
  	  	CountView countView = new CountView();
  	  	PositionsView positionsView = new PositionsView();
  	  	MessageView textView = new MessageView();
  	  	ClickView clickView = new ClickView();
  	  	ResetView resetView = new ResetView();
  	  	
  	  	//Initialize controllers
  	  	ClickCtrl clickCtrl = new ClickCtrl();
  	  	ResetCtrl resetCtrl = new ResetCtrl();
  	  	
  	  	/**********/
  	  	//Register controls to views
  	  	clickView.addController(clickCtrl);
  	  	resetView.addController(resetCtrl);
  	  	/**********/
  	  	
  	  	//Test1
  	  	//Check if the particular tile now shows 'X'
  	  	ArrayList<Integer> test1 = new ArrayList<Integer>();
  	  	test1.add(1);
  	  	clickView.update(test1);
  	  	String str1 = "X";
  	  	assertEquals(str1, clickView.getButton()[1].getText());
  	  	
  	  	//Test2
  	  	//Check if all buttons are enabled after reset
  	  	assertEquals(false, clickView.getButton()[1].isEnabled());
  	  	clickView.reset();
  	  	assertEquals(true, clickView.getButton()[1].isEnabled());
		
    }
}
