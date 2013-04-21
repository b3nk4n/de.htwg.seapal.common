package de.htwg.seapal.common.views.tui;

public interface TuiState {

	public void print();
	
	public boolean process(StateContext context, String input);
	
	
}
