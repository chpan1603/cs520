package view;

import java.util.ArrayList;

import javax.swing.JTextArea;
//import javax.swing.text.JTextComponent;
import javax.swing.JComponent;

public class PositionsView implements View {

	//Instance variables
	JTextArea jtaNumbers;
	String name;

	public PositionsView() {
		jtaNumbers = new JTextArea(10,50);
		jtaNumbers.setEditable(false);
		name = "Positions of Moves";
	}

	@Override
	public void update(ArrayList<Integer> positions) {
		jtaNumbers.setText("");
		for (Integer num: positions) {
			jtaNumbers.append((num+1) + ",");
		}
	}

	@Override
	public void reset() {
		jtaNumbers.setText("");
	}

	@Override
	public JComponent show() {
		return jtaNumbers;
	}

	@Override
	public String getName() {
		return name;
	}

}
