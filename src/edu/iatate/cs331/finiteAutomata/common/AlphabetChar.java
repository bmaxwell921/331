package edu.iatate.cs331.finiteAutomata.common;

/**
 * Convenience class wrapping up string
 * @author Brandon
 *
 */
public class AlphabetChar implements Comparable<AlphabetChar>{
	
	private String rep;
	
	public AlphabetChar(String rep) {
		this.rep = rep;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (o == this) return true;
		if (o.getClass() != this.getClass()) return false;
		
		AlphabetChar other = (AlphabetChar) o;
		
		return this.rep == other.rep || (this.rep != null && this.rep.equals(other.rep));
	}

	@Override
	public int hashCode() {
		return (rep == null) ? 0 : rep.hashCode();
	}
	
	@Override
	public String toString() {
		return rep;
	}

	@Override
	public int compareTo(AlphabetChar rhs) {
		if (this.rep == null && rhs.rep == null) return 0;
		
		if (this.rep == null) return -1;
		
		if (rhs.rep == null) return 1;
		
		return this.rep.compareTo(rhs.rep);
	}
}
