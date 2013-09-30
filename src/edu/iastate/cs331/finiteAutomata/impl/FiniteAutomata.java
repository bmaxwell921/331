package edu.iastate.cs331.finiteAutomata.impl;

import java.util.List;

import edu.iastate.cs331.finiteAutomata.IFiniteAutomata;
import edu.iatate.cs331.finiteAutomata.common.Alphabet;
import edu.iatate.cs331.finiteAutomata.common.AlphabetChar;
import edu.iatate.cs331.finiteAutomata.common.StateIdentification;

public class FiniteAutomata implements IFiniteAutomata {

	@Override
	public Alphabet getAlphabet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addState(StateIdentification sid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean addTransition(StateIdentification fsid,
			StateIdentification tsid, AlphabetChar transition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeState(StateIdentification sid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTransition(StateIdentification fsid,
			AlphabetChar transition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearFiniteAutomata() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setAlphabet(Alphabet alphabet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accepts(List<AlphabetChar> sequence) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
