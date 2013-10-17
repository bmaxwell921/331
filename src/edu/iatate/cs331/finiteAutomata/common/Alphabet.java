package edu.iatate.cs331.finiteAutomata.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Class to represent a set of AlphabetChars that make up 
 * an alphabet.
 * @author Brandon
 *
 * @param <Chars>
 */
public class Alphabet implements Iterable<AlphabetChar> {
	
	private Set<AlphabetChar> chars;
	
	private static final String NULL_CHAR_MESSAGE = "Give AlphabetChar was null.";
	
	public Alphabet() {
		chars = new HashSet<AlphabetChar>();
	}
	
	public Alphabet(Collection<AlphabetChar> chars) {
		chars = new HashSet<AlphabetChar>(chars);
	}
	
	/**
	 * Returns whether or not the given AlphabetChar is in this alphabet
	 * @param c
	 * @return
	 */
	public boolean containsChar(AlphabetChar c) {
		return chars.contains(c);
	}
	
	/**
	 * Adds the given AlphabetChar to this alphabet.
	 * @throws NullPointerException
	 * 						if the given AlphabetChar is null
	 * @param newChar
	 */
	public void addAlphabetChar(AlphabetChar newChar) {
		if (newChar == null) throw new NullPointerException(NULL_CHAR_MESSAGE);
		chars.add(newChar);
	}
	
	/**
	 * Removed the given AlphabetChar from the Alphabet.
	 * @throws NullPointerException
	 * 					if the given AlphabetChar is null.
	 * @param remChar
	 */
	public void removeAlphabetChar(AlphabetChar remChar) {
		if (remChar == null) throw new NullPointerException(NULL_CHAR_MESSAGE);
		chars.remove(remChar);
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o.getClass() != this.getClass()) return false;
		
		Alphabet other = (Alphabet) o;
		for (AlphabetChar otherC : other.chars) {
			if (!this.chars.contains(otherC)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int prime = 13;
		int ret = 1;
		
		ret = ret * prime + chars.hashCode();
		
		return ret;
	}
	
	/**
	 * Returns the string representation of this alphabet, in alpha-numeric order
	 */
	@Override
	public String toString() {
		List<AlphabetChar> ordered = new ArrayList<AlphabetChar>(chars);
		Collections.sort(ordered);
		return ordered.toString();
	}

	@Override
	public Iterator<AlphabetChar> iterator() {
		return (chars == null) ? null : chars.iterator();
	}
}
