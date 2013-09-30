package edu.iastate.cs331.finiteAutomata.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.iastate.cs331.finiteAutomata.IFiniteAutomata;
import edu.iastate.cs331.finiteAutomata.exceptions.NonEmptyFiniteAutomataException;
import edu.iastate.cs331.finiteAutomata.exceptions.NotInAlphabetException;
import edu.iastate.cs331.finiteAutomata.exceptions.StateAlreadyDefinedException;
import edu.iastate.cs331.finiteAutomata.exceptions.StateNotDefinedException;
import edu.iastate.cs331.finiteAutomata.exceptions.TransitionAlreadyDefinedException;
import edu.iastate.cs331.finiteAutomata.exceptions.TransitionNotDefinedException;
import edu.iatate.cs331.finiteAutomata.common.Alphabet;
import edu.iatate.cs331.finiteAutomata.common.AlphabetChar;
import edu.iatate.cs331.finiteAutomata.common.StateIdentification;

public abstract class FiniteAutomata implements IFiniteAutomata {
	
	private int stateCount;
	private int transitionCount;
	
	private Alphabet alphabet;
	
	// All the states in the finite automata, used to check uniqueness
	protected Map<StateIdentification, State> allStates;
	
	/*
	 *  The initial state(s) for the finite automata. Serves as a starting point
	 *  for evaluating acceptance.
	 */
	protected Set<State> initialStates;
	
	public FiniteAutomata(Alphabet alphabet) {
		stateCount = 0;
		transitionCount = 0;
		
		this.alphabet = alphabet;
		allStates = new HashMap<StateIdentification, State>();
		initialStates = new HashSet<State>();
	}
	
	@Override
	public void addState(StateIdentification sid) {
		if (allStates.containsKey(sid)) throw new StateAlreadyDefinedException();
		protAddState(sid);
	}
	
	protected abstract void protAddState(StateIdentification sid);
	
	@Override
	public void addTransition(StateIdentification fsid, StateIdentification tsid, AlphabetChar transition) {
		if (!allStates.containsKey(fsid) || !allStates.containsKey(tsid)) throw new StateNotDefinedException();
		if (!alphabet.containsChar(transition)) throw new NotInAlphabetException();
		protAddTransition(fsid, tsid, transition);
	}
	
	protected abstract void protAddTransition(StateIdentification fsid, StateIdentification tsid, AlphabetChar transition);
	
	@Override
	public void removeState(StateIdentification sid) {
		if (!allStates.containsKey(sid)) throw new StateNotDefinedException();
		protRemoveState(sid);
	}
	
	protected abstract void protRemoveState(StateIdentification sid);
	
	@Override
	public void removeTransition(StateIdentification sid, AlphabetChar transition) {
		if (!allStates.containsKey(sid)) throw new StateNotDefinedException();
		if (!alphabet.containsChar(transition)) throw new NotInAlphabetException();
		protRemoveTransition(sid, transition);
	}
	
	protected abstract void protRemoveTransition(StateIdentification sid, AlphabetChar transition);
	
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
			if (transitions.containsKey(c)) throw new TransitionAlreadyDefinedException("State: " + sid 
					+ " already defines a transition for AlphabetChar: " + c);
			transitions.put(c, to);
		}
		
		public void removeTransition(AlphabetChar c) {
			if (!transitions.containsKey(c)) throw new TransitionNotDefinedException("State: " + sid 
					+ " doesn't define a transition for: " + c);
			transitions.remove(c);
		}
	}
}
