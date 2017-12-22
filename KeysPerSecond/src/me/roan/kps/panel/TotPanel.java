package me.roan.kps.panel;

import me.roan.kps.Main;

/**
 * Panel used to display the
 * total number of keys pressed
 * @author Roan
 */
public final class TotPanel extends BasePanel {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 5628759695450014071L;
	/**
	 * Total number of hits
	 */
	public static int hits;

	@Override
	protected String getTitle() {
		return "TOT";
	}

	@Override
	protected String getValue() {
		return String.valueOf(hits);
	}
	
	@Override
	public int getIndex() {
		return Main.config.posTot;
	}
}