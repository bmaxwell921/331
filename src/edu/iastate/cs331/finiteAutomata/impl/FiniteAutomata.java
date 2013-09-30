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
	 * The initial state(s) for the finite automata. Serves as a starting point
	 * for evaluating acceptance.
	 */
	protected Set<State> startStates;

	/*
	 * The accepting state(s)
	 */
	protected Set<State> acceptStates;

	public FiniteAutomata(Alphabet alphabet) {
		stateCount = 0;
		transitionCount = 0;

		this.alphabet = alphabet;
		allStates = new HashMap<StateIdentification, State>();
		startStates = new HashSet<State>();
	}

	@Override
	public void addState(StateIdentification sid) {
		this.checkStateNotExists(sid);
		protAddState(sid);
	}

	protected abstract void protAddState(StateIdentification sid);

	@Override
	public void addTransition(StateIdentification fsid,
			StateIdentification tsid, AlphabetChar transition) {
		this.checkStateExists(fsid);
		this.checkStateExists(tsid);
		this.checkInAlphabet(transition);
		
		State src = this.allStates.get(fsid);
		State dest = this.allStates.get(tsid);
		
		src.addTransition(dest, transition);
	}

	@Override
	public void removeState(StateIdentification sid) {
		this.checkStateExists(sid);
		
		State rem = this.allStates.remove(sid);
		this.startStates.remove(rem);
		this.acceptStates.remove(rem);
	}

	@Override
	public void removeTransition(StateIdentification sid,
			AlphabetChar transition) {
		this.checkStateExists(sid);
		this.checkInAlphabet(transition);
		
		State rem = this.allStates.get(sid);
		rem.removeTransition(transition);
	}

	@Override
	public void setAlphabet(Alphabet alphabet) {
		if (!isEmpty())
			throw new NonEmptyFiniteAutomataException(
					"Tried to set the alphabet for a non empty Finite Automata.");
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

	@Override
	public void clearFiniteAutomata() {
		stateCount = 0;
		transitionCount = 0;

		allStates.clear();
		startStates.clear();
		acceptStates.clear();
	}

	@Override
	public void setAccepting(StateIdentification acceptingSid) {
		this.checkStateExists(acceptingSid);
		acceptStates.add(allStates.get(acceptingSid));
	}

	@Override
	public void removeAccepting(StateIdentification sid) {
		this.checkStateExists(sid);
		acceptStates.remove(allStates.get(sid));
	}

	@Override
	public void setStarting(StateIdentification startingSid) {
		this.checkStateExists(startingSid);
		startStates.add(allStates.get(startingSid));
	}

	@Override
	public void removeStarting(StateIdentification sid) {
		this.checkStateExists(sid);
		startStates.remove(allStates.get(sid));
	}
	

	@Override
	public boolean containsState(StateIdentification sid) {
		return this.allStates.containsKey(sid);
	}

	@Override
	public boolean containsTransition(StateIdentification fsid,
			StateIdentification tsid, AlphabetChar transition) {
		State src = this.allStates.get(fsid);
		return src.containsTransition(this.allStates.get(tsid), transition);
	}
	
	protected void checkStateExists(StateIdentification sid) {
		if (!allStates.containsKey(sid))
			throw new StateNotDefinedException("Tried to work with state: "
					+ sid + " but it didn't exist!");
	}

	protected void checkStateNotExists(StateIdentification sid) {
		if (allStates.containsKey(sid))
			throw new StateAlreadyDefinedException(
					"Tried to use StateIdentification: " + sid
							+ " but the State was already defined!");
	}

	protected void checkInAlphabet(AlphabetChar c) {
		if (!alphabet.containsChar(c))
			throw new NotInAlphabetException("Alphabet character: " + c
					+ " doesn't exist in the alphabet.");
	}

	/**
	 * Class representing a state in the finite automata. States have directed
	 * transitions coming out of them
	 * 
	 * @author Brandon
	 * 
	 */
	protected abstract class State {
		public StateIdentification sid;

		public State(StateIdentification sid) {
			this.sid = sid;
		}

		public abstract void addTransition(State to, AlphabetChar c);

		public abstract void removeTransition(AlphabetChar c);
		
		public abstract boolean containsTransition(State to, AlphabetChar c);
	}
}
