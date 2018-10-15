import java.util.ArrayList;

//Model interface
public interface Model {

	//Add observer to the model
	public void addObserver(View view);

	//addData allows for single data point to be added from any source
	public void addData(Integer data);

	//Updates each view
	public void updateViews();

	//Taking an ArrayList allows for data to be read in from this kind of data structure
	public void update(ArrayList<Integer> information);

	//returns data as ArrayList
	public ArrayList<Integer> getData();

}