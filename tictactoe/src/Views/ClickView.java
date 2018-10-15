package Views;
import Controllers.Controller;
import Models.Positions;
import Utility.BasicCalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ClickView implements View {

	//Instance variables
	Integer num;
	JPanel game;
	JButton[] blocks;
	ArrayList<Controller> controllers;

	public ClickView() {
		controllers = new ArrayList<Controller>();
		
		game = new JPanel(new GridLayout(3,3));
		blocks = new JButton[9];
		for(int i = 0; i<9 ;i++) {
            blocks[i] = new JButton();
            blocks[i].setPreferredSize(new Dimension(75,75));
            blocks[i].setText("");
            game.add(blocks[i]);
            blocks[i].addActionListener(new ActionListener() {
            	
            	//@Override
        		public void actionPerformed(ActionEvent e) {
            		for (int j = 0; j<9 ;j++) {
            			if(e.getSource()==blocks[j]) {
            				num = j;
            			}
            		}

        			for (Controller ctrl: controllers) {
        				ctrl.updateModels(num);
        			}

        		}
	
            });
         
		}
    }

	@Override
	public void update(ArrayList<Integer> positions) {
		int len = positions.size();
		int lastMove = positions.get(len-1);
		if (len%2 == 1) {
			blocks[lastMove].setText("X");
			blocks[lastMove].setEnabled(false);
		}
		else {
			blocks[lastMove].setText("O");
			blocks[lastMove].setEnabled(false);
		}
		String message = Positions.showmessage(BasicCalc.getArrayInteger(positions));
		if (message == "Player 1 wins!" || message == "Player 2 wins!") {
			for (int i = 0;i<9;i++) {
                blocks[i].setEnabled(false);
            }	
		}
	}

	@Override
	public void reset() {
		for (int pos = 0; pos < 9; pos++) {
			blocks[pos].setText("");
			blocks[pos].setEnabled(true);
		}
	}

	@Override
	public JComponent show() {
		return game;
	}

	@Override
	public String getName() {
		return "Click View";
	}

	public void addController(Controller ctrl) {
		controllers.add(ctrl);
	}

	public JButton[] getButton() {
		return blocks;
	}



}