package edu.iastate.cs331.finiteAutomata.impl;

import java.util.HashMap;
import java.util.Map;

import edu.iastate.cs331.finiteAutomata.IFiniteAutomata;
import edu.iastate.cs331.finiteAutomata.exceptions.NonEmptyFiniteAutomataException;
import edu.iastate.cs331.finiteAutomata.exceptions.NotInAlphabetException;
import edu.iastate.cs331.finiteAutomata.exceptions.TransitionNotDefinedException;
import edu.iatate.cs331.finiteAutomata.common.Alphabet;
import edu.iatate.cs331.finiteAutomata.common.AlphabetChar;
import edu.iatate.cs331.finiteAutomata.common.StateIdentification;

public abstract class FiniteAutomata implements IFiniteAutomata {
	
	private int stateCount;
	private int transitionCount;
	
	private Alphabet alphabet;
	
	public FiniteAutomata(Alphabet alphabet) {
		stateCount = 0;
		transitionCount = 0;
		
		this.alphabet = alphabet;
	}
	
	@Override
	public void setAlphabet(Alphabet alphabet) {
		if (!isEmpty()) throw new NonEmptyFiniteAutomataException();
		this.alphabet = alphabet;
	}
	
	@Override
	public Alphabet getAlphabet() {
		return alphabet;
	}
	
	@Override
	public boolean isEmpty() {
		return stateCount == 0 && transitionCount == 0;
	}
	
	/**
	 * Class representing a state in the finite automata. States have directed transitions coming out of them
	 * @author Brandon
	 *
	 */
	protected class State {
		public StateIdentification sid;
		public Map<AlphabetChar, State> transitions;
		public boolean isAccepting;
		
		public State(StateIdentification sid, boolean isAccepting) {
			this.sid = sid;
			this.isAccepting = isAccepting;
			this.transitions = new HashMap<AlphabetChar, State>();
		}
		
		public void addTransition(State to, AlphabetChar c) {
			if (!alphabet.containsChar(c)) throw new NotInAlphabetException("Given AlphabetChar: " + c 
					+ " didn't exist in the alphabet.");
			transitions.put(c, to);
		}
		
		public void removeTransition(AlphabetChar c) {
			if (!transitions.containsKey(c)) throw new TransitionNotDefinedException("State: " + sid 
					+ " doesn't define a transition for: " + c);
			transitions.remove(c);
		}
	}
}
