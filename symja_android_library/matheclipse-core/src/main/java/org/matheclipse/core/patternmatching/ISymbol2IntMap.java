package org.matheclipse.core.patternmatching;

import org.matheclipse.core.interfaces.ISymbol;

/**
 * Interface for mapping ISymbol objects to int values.
 * 
 */
public interface ISymbol2IntMap {

	/**
	 * Gives the number of symbols used in this map.
	 * 
	 * @return
	 */
	public int size();

	/**
	 * Gives <code>true</code> if there's no symbol used in this map.
	 * 
	 * @return
	 */
	public boolean isEmpty();

	/**
	 * Get the <code>int</code> value mapped to the given symbol.
	 * 
	 * @param symbol
	 * @return
	 */
	public int get(ISymbol symbol);

}
