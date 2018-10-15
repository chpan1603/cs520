package Views;
import Controllers.Controller;

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
            	
            	@Override
        		public void actionPerformed(ActionEvent e) {
            		for (int i = 0; i<9 ;i++) {
            			if(e.getSource()==blocks[i]) num = i;
            			break;
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
		for (int pos = 0; pos < positions.size(); pos++) {
			if (pos%2 == 1) {
				blocks[pos].setText("O");
				blocks[pos].setEnabled(false);
			}
			else {
				blocks[pos].setText("X");
				blocks[pos].setEnabled(false);
			}
		}
	}

	@Override
	public void reset() {
		for (int pos = 0; pos < 9; pos++) {
			blocks[pos].setText("");
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