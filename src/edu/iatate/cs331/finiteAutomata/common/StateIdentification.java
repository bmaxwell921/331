package edu.iatate.cs331.finiteAutomata.common;

/**
 * A unique id given to a state in a finite state machine. Again this is basically a 
 * convenience class wrapping string.
 * @author Brandon
 *
 */
public class StateIdentification {
	private String id;
	
	public StateIdentification(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || o.getClass() != this.getClass()) return false;
		if (o == this) return true;
		
		StateIdentification other = (StateIdentification) o;
		
		return this.id == other.id || (this.id != null && this.id.equals(other.id));
	}
	
	@Override
	public int hashCode() {
		return (id == null) ? 0 : id.hashCode();
	}
	
	@Override
	public String toString() {
		return id;
	}
}
