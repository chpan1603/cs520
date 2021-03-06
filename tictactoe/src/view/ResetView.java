package view;
import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

//View for reset button.

public class ResetView implements View {

	//Instance variables
	JButton jbReset;
	ArrayList<Controller> controllers;

	public ResetView() {
		controllers = new ArrayList<Controller>();

		jbReset = new JButton("Reset");
		jbReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (Controller ctrl: controllers) {
					ctrl.updateModels(0);
				}
			}

		});
	}

	@Override
	public void update(ArrayList<Integer> positions) {

	}

	@Override
	public void reset() {

	}

	@Override
	public JComponent show() {
		return null;
	}

	@Override
	public String getName() {
		return "Reset View";
	}

	public void addController(Controller ctrl) {
		controllers.add(ctrl);
	}

	public JButton getButton() {
		return jbReset;
	}


}