import java.util.ArrayList;

//Controller for ResetView
public class ResetCtrl implements Controller {

	ArrayList<Model> models;

	public ResetCtrl() {
		models = new ArrayList<Model>();
	}

	@Override
	public void addModel(Model model) {
		models.add(model);
	}

	@Override
	public void updateModels(Integer pos) {
		//New ArrayList resets model in Positions.java
		for (Model model: models) {
			model.update(new ArrayList<Integer>());
		}
	}

}