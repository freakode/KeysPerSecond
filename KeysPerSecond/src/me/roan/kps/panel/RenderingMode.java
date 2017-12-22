package me.roan.kps.panel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * An enum specifying the different
 * text rendering modes
 * @author Roan
 */
public enum RenderingMode {
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TN("Horizontal (text - value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(SizeManager.sideTextOffset, getHorizontalBaseline(panel, metrics));
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(value), getHorizontalBaseline(panel, metrics));
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_NT("Horizontal (value - text)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(title), getHorizontalBaseline(panel, metrics));
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(SizeManager.sideTextOffset, getHorizontalBaseline(panel, metrics));
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TAN("Horizontal (text above value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move((panel.getWidth() - metrics.stringWidth(title)) / 2, metrics.getAscent() + 1);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move((panel.getWidth() - metrics.stringWidth(value)) / 2, panel.getHeight() - SizeManager.sideTextOffset - 1);
		}
		
		@Override
		public Font getTitleFont(String title){
			return font1small;
		}
		
		@Override
		public Font getValueFont(String value) {
			return value.length() >= 9 ? font2smallest : (value.length() >= 6 ? font2small : font2);
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TDAN("Horizontal (text / value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(title), metrics.getAscent() + 1);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(SizeManager.sideTextOffset, panel.getHeight() - SizeManager.sideTextOffset - 1);
		}
		
		@Override
		public Font getValueFont(String value) {
			return value.length() >= 9 ? font2smallest : (value.length() >= 5 ? font2small : font2);
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TDAN2("Horizontal (text \\ value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(SizeManager.sideTextOffset, metrics.getAscent() + 1);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(value), panel.getHeight() - SizeManager.sideTextOffset - 1);
		}
		
		@Override
		public Font getValueFont(String value) {
			return value.length() >= 9 ? font2smallest : (value.length() >= 5 ? font2small : font2);
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TDANS("Horizontal (small text / value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(title), metrics.getAscent() + 1);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(SizeManager.sideTextOffset, panel.getHeight() - SizeManager.sideTextOffset - 1);
		}
		
		@Override
		public Font getTitleFont(String title){
			return font1small;
		}
		
		@Override
		public Font getValueFont(String value) {
			return value.length() >= 9 ? font2smallest : (value.length() >= 6 ? font2small : font2);
		}
	},
	/**
	 * HORIZONTAL text rendering
	 */
	HORIZONTAL_TDAN2S("Horizontal (small text \\ value)", Orientation.HORIZONTAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move(SizeManager.sideTextOffset, metrics.getAscent() + 1);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move(panel.getWidth() - SizeManager.sideTextOffset - metrics.stringWidth(value), panel.getHeight() - SizeManager.sideTextOffset - 1);
		}
		
		@Override
		public Font getTitleFont(String title){
			return font1small;
		}
		
		@Override
		public Font getValueFont(String value) {
			return value.length() >= 9 ? font2smallest : (value.length() >= 6 ? font2small : font2);
		}
	},
	/**
	 * VERTICAL text rendering
	 */
	VERTICAL("Vertical", Orientation.VERTICAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move((panel.getWidth() - metrics.stringWidth(title)) / 2, SizeManager.keyTitleTextOffset);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move((panel.getWidth() - metrics.stringWidth(value)) / 2, SizeManager.keyDataTextOffset);
		}
	},
	/**
	 * VERTICAL text rendering
	 */
	VERTICALS("Vertical small text", Orientation.VERTICAL) {
		@Override
		protected void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title) {
			point.move((panel.getWidth() - metrics.stringWidth(title)) / 2, SizeManager.keyTitleTextOffset);
		}

		@Override
		protected void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value) {
			point.move((panel.getWidth() - metrics.stringWidth(value)) / 2, SizeManager.keyDataTextOffset);
		}
		
		@Override
		public Font getTitleFont(String title){
			return font1small;
		}
	};
	
	/**
	 * The display name of the
	 * enum constant, used in dialogs
	 */
	private String name;
	/**
	 * Panel orientation
	 */
	public final Orientation orientation;
	/**
	 * Cache point that is constantly being reused and
	 * returned by the methods from this enum. This prevents
	 * the creation of a lot of extra objects. But prevents
	 * multiple points from this class existing at the same time.
	 */
	private static final Point point = new Point();
	/**
	 * Font 1 used to display the title of the panel
	 */
	protected static Font font1;
	/**
	 * Font 1 used to draw the title of the panel but smaller
	 */
	protected static Font font1small;
	/**
	 * Font 2 used to display the value of this panel
	 */
	protected static Font font2;
	/**
	 * Font 2 but smaller
	 */
	protected static Font font2small;
	/**
	 * Font 2 small but smaller
	 */
	protected static Font font2smallest;
	
	/**
	 * Constructs a new RenderingMode
	 * with the given name
	 * @param n The display name of the mode
	 * @param orientation The orientation of the panel
	 */
	private RenderingMode(String n, Orientation orientation){
		name = n;
		this.orientation = orientation;
	}
	
	/**
	 * Gets the font to be used to draw
	 * the given title
	 * @param title The title to draw
	 * @return The font to use for drawing the title
	 */
	public Font getTitleFont(String title){
		return title.length() == 1 ? font1 : font1small;
	}
	
	/**
	 * Gets the font to be used to draw
	 * the given value
	 * @param value The value to be drawn
	 * @return the font to use for the value text
	 */
	public Font getValueFont(String value) {
		return value.length() >= 5 ? font2smallest : (value.length() >= 4 ? font2small : font2);
	}
	
	/**
	 * Mode specific logic for the title position
	 * @param metrics FontMetrics that will be used to draw the title
	 * @param baseline Baseline that will be used to draw the title
	 * @param width Panel width
	 * @param height Panel height
	 * @param title The title that will be drawn
	 * @return The location at which the title should be drawn
	 */
	protected abstract void setTitleDrawPositionImpl(FontMetrics metrics, BasePanel panel, String title);
	
	/**
	 * Mode specific logic for the value position
	 * @param metrics FontMetrics that will be used to draw the value
	 * @param baseline Baseline that will be used to draw the value
	 * @param width Panel width
	 * @param height Panel height
	 * @param value The value that will be drawn
	 * @return The location at which the value should be drawn
	 */
	protected abstract void setValueDrawPositionImpl(FontMetrics metrics, BasePanel panel, String value);
	
	/**
	 * Gets the location at which the panel title should be drawn
	 * Points returned by this class are not static
	 * @param g The graphics used for drawing
	 * @param panel The panel
	 * @param title The title
	 * @param font The font with which the title is going to be drawn
	 * @return The location at which the title should be drawn
	 */
	public Point getTitleDrawPosition(Graphics2D g, BasePanel panel, String title, Font font){
		setTitleDrawPositionImpl(g.getFontMetrics(font), panel, title);
		return point;
	}
	
	/**
	 * Gets the location at which the panel value should be drawn
	 * Points returned by this class are not static
	 * @param g The graphics used for drawing
	 * @param panel The panel
	 * @param title The value
	 * @param font The font with which the value is going to be drawn
	 * @return The location at which the value should be drawn
	 */
	public Point getValueDrawPosition(Graphics2D g, BasePanel panel, String value, Font font){
		setValueDrawPositionImpl(g.getFontMetrics(font), panel, value);
		return point;
	}
	
	/**
	 * Gets the baseline to draw text in the panel
	 * @param panel The panel
	 * @param font The font used for drawing
	 * @return The horizontal baseline to use for drawing
	 */
	private static int getHorizontalBaseline(BasePanel panel, FontMetrics metrics) {
		return (panel.getHeight() + metrics.getAscent() - metrics.getDescent()) / 2;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	/**
	 * Simple enum specifying the possible
	 * panel orientations
	 * @author Roan
	 */
	public static enum Orientation{
		/**
		 * Horizontal panel orientation
		 */
		HORIZONTAL,
		/**
		 * Vertical panel orientation
		 */
		VERTICAL;
	}
}
