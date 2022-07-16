package com.github.pitzzahh.computing;

import static com.github.pitzzahh.computing.QuadrantAnalyzer.Quadrant.*;

/**
 * Class used in performing quadrant analyzing.
 * @param <T> the x coordinate.
 * @param <S> the y coordinate.
 */
public final class QuadrantAnalyzer <T extends Number, S extends Number> {

	private T x;
	private S y;

	/**
	 * All args constructor for {@code QuadrantAnalyzer} class.
	 * @param x the x coordinate.
	 * @param y the y coordinate.
	 */
	public QuadrantAnalyzer(T x, S y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * No args constructor.
	 */
	public QuadrantAnalyzer() {
	}

	/**
	 * Gets the quadrant position of the coordinates.
	 * @return {@code Quadrant}
	 * @see Quadrant
	 */
	public Quadrant getQuadrant() {
		return whichQuadrant(this.x, this.y);
	}

	/**
	 * Method that identifies which quadrant the point is.
	 * @param x the x position on the board
	 * @param y the y position on the board
	 * @return {@code Quadrant}
	 */
	private static Quadrant whichQuadrant(Number x, Number y) {
		if (x.intValue() > 0 && y.intValue()  > 0) return FIRST_QUADRANT;
	    else if (x.intValue()  < 0 && y.intValue()  > 0) return SECOND_QUADRANT;
	    else if (x.intValue()  < 0 && y.intValue()  < 0) return THIRD_QUADRANT;
	    else if (x.intValue()  > 0 && y.intValue()  < 0) return FOURTH_QUADRANT;
	    else return ORIGIN;
	}

	/**
	 * Gets the x coordiinate
	 * @return {@code T}, the x coordinte
	 */
	public T getX() {
		return this.x;
	}

	/**
	 * Gets the y coordiinate
	 * @return {@code S}, the y coordinte
	 */
	public S getY() {
		return this.y;
	}

	/**
	 * Specifies which quadrant the coordinate will be using.
	 */
	enum Quadrant {
		
		/**
		 * If lies in the first quadrant
		 */
		FIRST_QUADRANT,
		/**
		 * If lies in the second quadrant
		 */
		SECOND_QUADRANT,
		/**
		 * If lies in the third quadrant
		 */
		THIRD_QUADRANT,
		/**
		 * If lies in the fourth quadrant
		 */
		FOURTH_QUADRANT,
		/**
		 * If lies at the origin.
		 */
		ORIGIN
	}
}
