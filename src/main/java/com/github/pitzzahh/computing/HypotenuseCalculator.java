package com.github.pitzzahh.computing;

import java.math.BigDecimal;

/**
 * Class used in performing hypotenuse calculations.
 * @param <T> the x coordinate.
 * @param <S> the y coordinate.
 */
public class HypotenuseCalculator<T extends Number, S extends Number> {

	private T x;
	private S y;

	/**
	 * All args constructor for {@code HypotenuseCalculator} class.
	 * @param x the x coordinate.
	 * @param y the y coordinate.
	 */
	public HypotenuseCalculator(T x, S y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * No args constructor.
	 */
	public HypotenuseCalculator() {
	}

	/**
	 * Computes the hypotenuse.
	 * @return the computed hypotenuse.
	 */
	public BigDecimal getHypotenuse() {
		var xValue = this.x instanceof Integer ? String.valueOf(this.x.intValue()) : this.x instanceof Double ? String.valueOf(this.x.doubleValue()) : String.valueOf(this.x.byteValue());
		var yValue = this.y instanceof Integer ? String.valueOf(this.y.intValue()) : this.y instanceof Double ? String.valueOf(this.y.doubleValue()) : String.valueOf(this.y.byteValue());
		var x = new BigDecimal(xValue);
		var y = new BigDecimal(yValue);
		return BigDecimal.valueOf(Math.sqrt((x.doubleValue() * x.doubleValue()) + (y.doubleValue() * y.doubleValue())));
	}

	public T getX() {
		return this.x;
	}

	public S getY() {
		return this.y;
	}
}
