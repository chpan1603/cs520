import java.util.ArrayList;

import javax.swing.JComponent;

//Interface for use of template method.
public interface View {

	public void update(ArrayList<Integer> positions);
	public void reset();
	public JComponent show();
	public String getName();

}