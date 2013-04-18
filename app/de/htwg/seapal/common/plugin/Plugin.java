package de.htwg.seapal.common.plugin;

public interface Plugin {
	
	/**
	 * Gets the menu entry title.
	 * @return The menu entry title.
	 */
	public String getMenuEntry();
	
	/**
	 * Gets the menu key.
	 * @return The menu key character.
	 */
	public char getMenuKey();
	
	/**
	 * Prints out the menu.
	 */
	public void printTUI();
	
	/**
	 * Processes the input line.
	 * @param line the read input line.
	 * @return Returns TRUE, if the plugin wants to read another input line.
	 */
	public boolean processInputLine(String line);

}
