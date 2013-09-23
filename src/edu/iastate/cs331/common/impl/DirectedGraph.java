package edu.iastate.cs331.common.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import edu.iastate.cs331.common.IGraph;

/**
 * Concrete implementation of the IGraph interface
 * @author brandon
 *
 * @param <E>
 * 				The data type held in this graph
 */
public class DirectedGraph<E> implements IGraph<E> {

	private Map<E, GNode> nodes;
	private int size;
	
	private class GNode {
		public E data;
		public Set<GNode> neighbors;
		
		public GNode(E data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			// TODO
			return null;
		}
		
		@Override
		public int hashCode() {
			return data.hashCode();
		}
		
		public String dataToString() {
			return data.toString();
		}
	}
	
	public DirectedGraph() {
		this.nodes = new HashMap<E, GNode>();
		this.size = 0;
	}
	
	@Override
	public boolean addData(E data) {
		if (nodes.containsKey(data)) {
			return false;
		}
		GNode n = new GNode(data);
		nodes.put(data, n);
		return true;
	}

	@Override
	public boolean addEdge(E from, E to) {
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
