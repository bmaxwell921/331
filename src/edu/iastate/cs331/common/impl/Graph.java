package edu.iastate.cs331.common.impl;

import java.util.Map;
import java.util.Set;

import edu.iastate.cs331.common.IGraph;

/**
 * Concrete implementation of the IGraph interface
 * @author brandon
 *
 * @param <D>
 * 				The data type held in this graph
 */
public class Graph<D> implements IGraph<D> {

	private Map<D, GNode> nodes;
	
	private class GNode {
		public D data;
		public Set<GNode> neighbors;
		
		public GNode(D data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			// TODO
			return null;
		}
		
		public String dataToString() {
			return data.toString();
		}
	}
	
	@Override
	public boolean addData(D data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEdge(D from, D to) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toStringDfs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toStringBfs() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO
		return null;
	}

}
