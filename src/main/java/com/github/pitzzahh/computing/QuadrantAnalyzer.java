package com.github.pitzzahh.computing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import static com.github.pitzzahh.computing.QuadrantAnalyzer.Quadrant.*;

/**
 * Class used in performing quadrant analyzing.
 * @param <T> the x coordinate.
 * @param <S> the y coordinate.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public final class QuadrantAnalyzer <T extends Number, S extends Number> {

	private T x;
	private S y;

	/**
	 * Gets the quadrant position of the coordinates.
	 * @return {@code Quadrant}
	 * @see Quadrant
	 */
	public Quadrant getQuadrant() {
		return whichQuadrant(this.x.byteValue(), this.y.byteValue());
	}

	/**
	 * Method that identifies which quadrant the point is.
	 * @param x the x position on the board
	 * @param y the y position on the board
	 * @return {@code Quadrant}
	 */
	private static Quadrant whichQuadrant(byte x, byte y) {
		if (x > 0 && y > 0) return FIRST_QUADRANT;
	    else if (x < 0 && y > 0) return SECOND_QUADRANT;
	    else if (x < 0 && y < 0) return THIRD_QUADRANT;
	    else if (x > 0 && y < 0) return FOURTH_QUADRANT;
	    else return ORIGIN;
	}

	/**
	 * Specifies which quadrant the coordinate will be using.
	 */
	enum Quadrant {
		FIRST_QUADRANT,
		SECOND_QUADRANT,
		THIRD_QUADRANT,
		FOURTH_QUADRANT,
		ORIGIN
	}
}
