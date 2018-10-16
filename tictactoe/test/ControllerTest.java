import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import controller.*;
import model.*;
import view.*;

/**
 * A controller test class.
 * Test1 tests ClickCtrl.
 * Test2 tests ResetCtrl.
 */
public class ControllerTest {
    @Test
    public void testNewGame() {
    	//Initialize controllers
  	  	ClickCtrl clickCtrl = new ClickCtrl();
  	  	ResetCtrl resetCtrl = new ResetCtrl();

  	  	//Initialize model
  	  	Positions positions = new Positions();

  	  	/**********/
  	  	//Register models to controls
  	  	clickCtrl.addModel(positions);
  	  	resetCtrl.addModel(positions);
  	  	/**********/
  	  	
  	  	//Test1
  	  	//Ask the model to update a move
  	  	Integer pos = new Integer(1);
  	  	clickCtrl.updateModels(pos);
  	  	// check if model is updated
  	  	ArrayList<Integer> test1 = new ArrayList<Integer>();
  	  	test1.add(1);
  	  	assertEquals(test1, positions.getData());
  	  	
  	  	//Test2
  	  	//Ask the model to reset
  	  	resetCtrl.updateModels(pos);
  	  	// check if model is updated
  	  	ArrayList<Integer> test2 = new ArrayList<Integer>();
  	  	assertEquals(test2, positions.getData());
  	  	
    }
}
