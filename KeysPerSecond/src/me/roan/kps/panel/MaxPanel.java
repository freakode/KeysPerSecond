package me.roan.kps.panel;

import me.roan.kps.Main;

/**
 * Panel used to display the
 * maximum keys pressed per second
 * @author Roan
 */
public final class MaxPanel extends BasePanel {
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8816524158873355997L;

	@Override
	protected String getTitle() {
		return "MAX";
	}

	@Override
	protected String getValue() {
		return String.valueOf(Main.max);
	}

	@Override
	public int getIndex() {
		return Main.config.posMax;
	}
}