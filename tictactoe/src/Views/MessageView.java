import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JComponent;

public class MessageView implements View {

	//Instance variables
	//double median;
	JTextField jtfMessage; //playerturn
	String name;

	public MessageView() {
		//median = 0;
		jtfMessage = new JTextField(15);
		jtfMessage.setEditable(false);
		name = "Message";
	}

	@Override
	public void update(ArrayList<Integer> positions) {
		message = Positions.showmessage(BasicCalc.getArrayInteger(positions));

		//Set text
		jtfMessage.setText(message);

	}

	@Override
	public void reset() {
		jtfMessage.setText("Player 1 to play 'X'");
	}

	@Override
	public JComponent show() {
		return jtfMessage;
	}

	@Override
	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

}