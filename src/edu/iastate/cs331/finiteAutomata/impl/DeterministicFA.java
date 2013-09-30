package edu.iastate.cs331.finiteAutomata.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iastate.cs331.finiteAutomata.exceptions.*;
import edu.iatate.cs331.finiteAutomata.common.*;

/**
 * DFAs: - All states must define transitions for every character in the
 * alphabet - Have only 1 start state - Can have multiple accepting states
 * 
 * @author brandon
 * 
 */
public class DeterministicFA extends FiniteAutomata {

	public DeterministicFA(Alphabet alphabet) {
		super(alphabet);
	}

	@Override
	public void setStarting(StateIdentification sid) {
		super.checkStateExists(sid);
		if (super.startStates.size() != 0)
			throw new StartAlreadyDefinedException(
					"This DFA already defines a start state. There can be only one...");
		super.startStates.add(super.allStates.get(sid));
	}

	@Override
	public boolean accepts(List<AlphabetChar> sequence) {
		// TODO
		/*
		 * Check if the DFA is fully defined -> every state needs to have
		 * transitions for every alphabet character.
		 */
		return false;
	}
	
	private boolean isFullyDefined() {
		//TODO
		return false;
	}

	@Override
	protected void protAddState(StateIdentification sid) {
		super.allStates.put(sid, new DFAState(sid));		
	}

	/**
	 * Class to represent a state in a DFA. In this case DFAs can only have 1
	 * transition per AlphabetChar
	 * 
	 * @author brandon
	 * 
	 */
	private class DFAState extends State {
		private Map<AlphabetChar, State> transitions;

		public DFAState(StateIdentification sid) {
			super(sid);
			transitions = new HashMap<AlphabetChar, State>();
		}

		@Override
		public void addTransition(State to, AlphabetChar c) {
			if (transitions.containsKey(c))
				throw new TransitionAlreadyDefinedException("State: " + sid
						+ " already defines a transition for AlphabetChar: "
						+ c);
			transitions.put(c, to);
		}

		@Override
		public void removeTransition(AlphabetChar c) {
			if (!transitions.containsKey(c))
				throw new TransitionNotDefinedException("State: " + sid
						+ " doesn't define a transition for: " + c);
			transitions.remove(c);
		}
		
		@Override
		public boolean containsTransition(State to, AlphabetChar c) {
			if (!transitions.containsKey(c))
				return false;
			return transitions.get(c).equals(to);
		}

	}

}
