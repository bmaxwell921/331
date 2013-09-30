package edu.iastate.cs331.finiteAutomata;

import java.util.List;

import edu.iastate.cs331.finiteAutomata.exceptions.NotInAlphabetException;
import edu.iatate.cs331.finiteAutomata.common.Alphabet;
import edu.iatate.cs331.finiteAutomata.common.AlphabetChar;
import edu.iatate.cs331.finiteAutomata.common.StateIdentification;

/**
 * Interface to outline basic behavior for finite automata. 
 * Alphabets for finite automata are always sets of Strings to
 * reduce complexity and align with what happens in practice.
 * @author Brandon
 *
 */
public interface IFiniteAutomata {
	
	/**
	 * Gets the alphabet associated with this FiniteAutomata
	 * @return
	 * 			The alphabet associated with this FiniteAutomata
	 */
	public Alphabet getAlphabet();
	
	/**
	 * Adds a state to the finite automata with the given name, leaving it
	 * unlinked from any other states.
	 * @param sid
	 * 				The name for the new state
	 * @throws StateNotDefinedException
	 * 					if the state with the given identification can't be found
	 */
	public void addState(StateIdentification sid);
	
	/**
	 * Adds a directed edge from the state identified as fromState, to the state identified
	 * as toState, with transition as the character in the alphabet linking the two states.
	 * 
	 * For example:
	 * FA.addTransition(A, AB, B)
	 * 
	 * Results in a FA that looks like:
	 * 
	 * 		B
	 * (A)---->(AB)
	 * 
	 * Meaning if we are at state (A) and a B is read, we will transition to state (AB)
	 *  
	 * @param fsid
	 * 					the name of the state that this transition starts at
	 * @param tsid
	 * 					the name of the state that this transition goes to
	 * @param transition
	 * 					the character in the alphabet linking the two states.
	 * @throws NotInAlphabetException
	 * 					if the transition is not in this finite automata's alphabet
	 * @throws StateNotDefinedException
	 * 					if either state with the given identifications can't be found
	 */
	public void addTransition(StateIdentification fsid, StateIdentification tsid, AlphabetChar transition);
	
	/**
	 * Removes the state identified by name from this finite automata. Any other states
	 * linking to the state to be removed will be updated to have those transitions
	 * deleted as well.
	 * 
	 * @param sid
	 * 				The name of the state to be removed
	 * @throws StateNotDefinedException
	 * 					if the state with the given identification can't be found
	 */
	public void removeState(StateIdentification sid);
	
	/**
	 * Removes the transition linking fromState to another state through
	 * the transition transition.
	 * 
	 * Returns false if the transition doesn't exist
	 * @param fsid
	 * @param transition
	 * @throws StateNotDefinedException
	 * 					if the state with the given identification can't be found
	 * @throws TransitionNotDefinedException
	 * 					if the the given state doesn't define a transition for the given AlphabetChar
	 */
	public void removeTransition(StateIdentification fsid, AlphabetChar transition);
	
	/**
	 * Removes all states and transitions from this finite automata.
	 */
	public void clearFiniteAutomata();
	
	/**
	 * Sets this finite automata's alphabet. Returns false
	 * if a finite automata is not empty.
	 * @param alphabet
	 * @throws NonEmptyFiniteAutomataException
	 */
	public void setAlphabet(Alphabet alphabet);
	
	/**
	 * Returns whether this finite automata has any states or transitions
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Returns whether this finite automata accepts the given sequence of 
	 * elements.
	 * @param sequence
	 * @throws NotInAlphabetException
	 * 					if any AlphabetChar is not in this finite automata's alphabet
	 * @throws TransitionNotDefinedException
	 * 					if the the given state doesn't define a transition for the given AlphabetChar
	 * @return
	 */
	public boolean accepts(List<AlphabetChar> sequence);
	
	/**
	 * Sets the state with the given state identification as accepting
	 * @param acceptingSid
	 * @throws StateNotDefinedException
	 * 					if the state with the given identification can't be found
	 */
	public void setAccepting(StateIdentification acceptingSid);
	
	/**
	 * Sets the state with the given state identification as accepting
	 * @param startingSid
	 * @throws StateNotDefinedException
	 * 				if the state with the given identification can't be found
	 */
	public void setStarting(StateIdentification startingSid);
}
