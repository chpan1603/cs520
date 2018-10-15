import java.util.ArrayList;

//Controller for ClickView
public class ClickCtrl implements Controller {

	ArrayList<Model> models;

	public ClickCtrl() {
		models = new ArrayList<Model>();
	}

	@Override
	public void addModel(Model model) {
		models.add(model);
	}

	@Override
	public void updateModels(Integer pos) {

		for (Model model: models) {
			model.addData(pos);
		}
	}

}