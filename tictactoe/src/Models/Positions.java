import java.util.ArrayList;
import java.util.Arrays;

//Model for this game
public class Positions implements Model {

	//Variables for Model
	ArrayList<Integer> positions;
	ArrayList<View> observers;

	public Positions() {
		positions = new ArrayList<Integer>();
		observers = new ArrayList<View>();
	}

	@Override
	public void addObserver(View view) {
		observers.add(view);
	}

	@Override
	public void addData(Integer pos) {
		positions.add(pos);

		updateViews();
	}

	@Override
	public void updateViews() {

		for (View view: observers) {
			if (positions.size() == 0) {
				view.reset();
			}
			else {
				view.update(positions);
			}
		}
	}

	@Override
	public void update(ArrayList<Integer> information) {
		if (information.size() == 0) {
			positions = information;
		}
		else {
			positions.addAll(information);
		}

		updateViews();
	}

	@Override
	public ArrayList<Integer> getData() {
		return positions;
	}

	/**
	 * Compute the turn/winner of the game.
	 */
	public static String showmessage(int ... positions) {
	    int len = positions.length;
	    if (len <= 4) {
	    	if (len%2 == 1) return "'O': Player 2";
	    	else return "'X': Player 1";
	    }
	    else {
	    	ArrayList<ArrayList<int[]>> map = winMap();
	    	int lastMove = positions[len-1];
	    	ArrayList<int[]> winLines = map.get(lastMove);
	    	if (len%2 == 1) { // Check whether player 1 wins
	    		int[] moves = new int[len/2+1];
	    		for (int i = 0; i < len; i++) {
	    			if (i%2 == 0) moves[i/2] = positions[i];
	    		}
	    		for (int[] line : winLines) {
	    			if (Arrays.asList(moves).contains(line[0]) && Arrays.asList(moves).contains(line[1])) {
	    				return "Player 1 wins!";
	    			}
	    		}
	    		return "Game ends in a draw";
	    	} 
	    	else { // Check whether player 2 wins
	    		int[] moves = new int[len/2];
	    		for (int i = 0; i < len; i++) {
	    			if (i%2 == 1) moves[i/2] = positions[i];
	    		}
	    		for (int[] line : winLines) {
	    			if (Arrays.asList(moves).contains(line[0]) && Arrays.asList(moves).contains(line[1])) {
	    				return "Player 2 wins!";
	    			}
	    		}
	    		return "Game ends in a draw";
	    	}	    	
	    }
	}
	
	public static ArrayList<ArrayList<int[]>> winMap() {
		int[] line01 = { 1, 2 };
		int[] line02 = { 4, 8 };
		int[] line03 = { 3, 6 };
		ArrayList<int[]> line0 = new ArrayList<int[]>();
		line0.add(line01);
		line0.add(line02);
		line0.add(line03);
		
		int[] line11 = { 0, 2 };
		int[] line12 = { 4, 7 };
		ArrayList<int[]> line1 = new ArrayList<int[]>();
		line1.add(line11);
		line1.add(line12);
		
		int[] line21 = { 0, 1 };
		int[] line22 = { 4, 6 };
		int[] line23 = { 5, 8 };
		ArrayList<int[]> line2 = new ArrayList<int[]>();
		line2.add(line21);
		line2.add(line22);
		line2.add(line23);
		
		int[] line31 = { 4, 5 };
		int[] line32 = { 0, 6 };
		ArrayList<int[]> line3 = new ArrayList<int[]>();
		line3.add(line31);
		line3.add(line32);
		
		int[] line41 = { 3, 5 };
		int[] line42 = { 0, 8 };
		int[] line43 = { 2, 6 };
		int[] line44 = { 1, 7 };
		ArrayList<int[]> line4 = new ArrayList<int[]>();
		line4.add(line41);
		line4.add(line42);
		line4.add(line43);
		line4.add(line43);
		
		int[] line51 = { 3, 4 };
		int[] line52 = { 2, 8 };
		ArrayList<int[]> line5 = new ArrayList<int[]>();
		line5.add(line51);
		line5.add(line52);
		
		int[] line61 = { 7, 8 };
		int[] line62 = { 2, 4 };
		int[] line63 = { 0, 3 };
		ArrayList<int[]> line6 = new ArrayList<int[]>();
		line6.add(line61);
		line6.add(line62);
		line6.add(line63);
		
		int[] line71 = { 6, 8 };
		int[] line72 = { 1, 4 };
		ArrayList<int[]> line7 = new ArrayList<int[]>();
		line7.add(line71);
		line7.add(line72);
		
		int[] line81 = { 6, 7 };
		int[] line82 = { 0, 4 };
		int[] line83 = { 2, 5 };
		ArrayList<int[]> line8 = new ArrayList<int[]>();
		line8.add(line81);
		line8.add(line82);
		line8.add(line83);
		
		ArrayList<ArrayList<int[]>> lines = new ArrayList<ArrayList<int[]>>();
		lines.add(line0);
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add(line4);
		lines.add(line5);
		lines.add(line6);
		lines.add(line7);
		lines.add(line8);
		
		return lines;
	}

}