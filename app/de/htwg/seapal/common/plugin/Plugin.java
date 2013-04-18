package de.htwg.seapal.common.plugin;

public interface Plugin {
	
	public String getMenuEntry();
	
	// Use a single character string for the key
	public char getMenuKey();
	
	public void printTUI();
	
	public boolean processInputLine(String line);

}
