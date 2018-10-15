import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JComponent;

//View for count of numbers
public class CountView implements View {

	//Instance variables
	int count;
	JTextField jtfCount;
	String name;

	public CountView() {
		count = 0;
		jtfCount = new JTextField(5);
		jtfCount.setEditable(false);
		name = "Counts";
	}

	@Override
	public void update(ArrayList<Integer> positions) {
		count = positions.size();

		jtfCount.setText("" + count);

	}

	@Override
	public void reset() {
		jtfCount.setText("");
	}

	@Override
	public JComponent show() {
		return jtfCount;

	}

	@Override
	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

}
