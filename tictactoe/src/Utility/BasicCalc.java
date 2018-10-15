package Utility;
import Controllers.ClickCtrl;
import Controllers.ResetCtrl;
import Models.Positions;
import Views.ClickView;
import Views.CountView;
import Views.MessageView;
import Views.PositionsView;
import Views.ResetView;
import Views.View;


import java.util.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * A simple class to calculate moves.
 */
public class BasicCalc {
	

	// Store all collected numbers
	private static ArrayList<Integer> data = new ArrayList<Integer>();

	public static void main(String ... args) {

	  //Initialize controllers
	  ClickCtrl clickCtrl = new ClickCtrl();
	  ResetCtrl resetCtrl = new ResetCtrl();

	  //Initialize model
	  Positions positions = new Positions();

	  //Initialize views
	  CountView countView = new CountView();
	  PositionsView positionsView = new PositionsView();
	  MessageView textView = new MessageView();
	  ClickView clickView = new ClickView();
	  ResetView resetView = new ResetView();

	  //Create statsView
	  ArrayList<View> statsViews = new ArrayList<View>();
	  statsViews.add(countView);
	  statsViews.add(textView);

	  /***** REGISTER MVC BLOCK *****/

	  //Register models to controls
	  clickCtrl.addModel(positions);
	  resetCtrl.addModel(positions);

	  //Register views to models
	  for (View view: statsViews) {
	    positions.addObserver(view);
	  }
	  positions.addObserver(positionsView);
	  positions.addObserver(clickView);
	  positions.addObserver(resetView);

	  //Register controls to views
	  clickView.addController(clickCtrl);
	  resetView.addController(resetCtrl);

	  /***** END OF REGISTER MVC BLOCK *****/

	  // Create the main frame of the application, and set size and position
	  JFrame gui = new JFrame("Tic TacToe");
	  gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gui.setSize(new Dimension(500, 350));
      gui.setResizable(true);
      gui.setLocationRelativeTo(null);
      
      // Panel that shows count and text about moves
      JPanel gameStats = new JPanel(new FlowLayout(FlowLayout.CENTER));
      
      // Panel that shows count and text about the moves
      for (View view: statsViews) {
  	    gameStats.add(new JLabel(view.getName() + ":"));
  	    gameStats.add(view.show());
  	  }
      
      // Set stats view
      gui.getContentPane().add(gameStats, BorderLayout.SOUTH);
      
      // TextArea that shows all the positions
      gui.getContentPane().add(positionsView.show(), BorderLayout.NORTH);
      
      // Create panel for input
	  JPanel gameInput = new JPanel(new FlowLayout(FlowLayout.CENTER));
	  gameInput.add(clickView.show());
	  //gameInput.add(clickView.getButton());
	  gameInput.add(resetView.getButton());

	  // Set input view
	  gui.getContentPane().add(gameInput, BorderLayout.CENTER);

	  // Show the frame
	  gui.setVisible(true);

	}
	
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


