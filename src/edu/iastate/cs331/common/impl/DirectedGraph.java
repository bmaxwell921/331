package edu.iastate.cs331.common.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

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
	
	private static final String MINOR_DELIMIT = ",";
	private static final String MAJOR_DELIMIT = ";";
	
	private class GNode {
		public E data;
		public Set<GNode> neighbors;
		
		public GNode(E data) {
			this.data = data;
			neighbors = new HashSet<GNode>();
		}
		
//		@Override
//		public String toString() {
//			// TODO
//			return null;
//		}
		
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
	
//	/**
//	 * Creates a DirectedGraph from the given list of edges.
//	 * The string should have the form: "a,b;b,c;c,d;d,a" where
//	 * nodes are delimited by commas and edges are delimited by ;.
//	 * The first element in the edge pair is the from node, and the
//	 * second element in the pair is the to node.
//	 * 
//	 * The graph from the example string would be represented as such:
//	 * 
//	 * 	a -> b -> c -> d
//	 * 	 ^\			  /
//	 * 	  ------------
//	 * @param edges
//	 */
//	public DirectedGraph(String edgeList) {
//		// Splits into individual edge
//		StringTokenizer major = new StringTokenizer(edgeList, MAJOR_DELIMIT);
//		
//		while (major.hasMoreTokens()) {
//			String edgePair = major.nextToken();
//			
//			// Splits into each node
//			StringTokenizer minor = new StringTokenizer(edgePair, MINOR_DELIMIT);
//			if (!minor.hasMoreTokens()) {
//				continue;
//			}
//			String from = minor.nextToken();
//			if (!minor.hasMoreTokens()) {
//				continue;
//			}
//			String to = minor.nextToken();
//			
//			this.addEdgeCreate(from, to);
//		}
//	}
	
	@Override
	public boolean addData(E data) {
		if (nodes.containsKey(data)) {
			return false;
		}
		GNode n = new GNode(data);
		nodes.put(data, n);
		++size;
		return true;
	}

	@Override
	public boolean addEdge(E from, E to) {
		if (!nodes.containsKey(from) && !nodes.containsKey(to)) {
			return false;
		}
		GNode fromN = nodes.get(from);
		GNode toN = nodes.get(to);
		
		fromN.neighbors.add(toN);
		return true;
	}
	
	// Adds an edge from from to to, adding nodes as necessary
	private void addEdgeCreate(E from, E to) {
		this.addData(from);
		this.addData(to);
		this.addEdge(from, to);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public String toStringDfs() {
		StringBuilder sb = new StringBuilder();
		Set<GNode> closed = new HashSet<GNode>();
		for (E ele : nodes.keySet()) {
			GNode n = nodes.get(ele);
			if (!closed.contains(n)) {
				dfsRec(n, closed, sb);
			}
		}
		return sb.toString();
	}
	
	private void dfsRec(GNode n, Set<GNode> closed, StringBuilder sb) {
		if (n == null) return;
		
		sb.append(n.dataToString()).append(IGraph.NODE_DELIMIT);
		closed.add(n);
		
		for (GNode neigh : n.neighbors) {
			if (!closed.contains(neigh)) {
				dfsRec(neigh, closed, sb);
			}
		}
	}

	@Override
	public String toStringBfs() {
		StringBuilder sb = new StringBuilder();
		Set<GNode> closed = new HashSet<GNode>();
		for (E nKey : nodes.keySet()) {
			GNode n = nodes.get(nKey);
			if (!closed.contains(n)) {
				bfsPriv(n, closed, sb);
			}
		}
		
		return sb.toString();
	}
	
	private void bfsPriv(GNode n, Set<GNode> closed, StringBuilder sb) {
		Queue<GNode> q = new LinkedList<GNode>();
		q.offer(n);
		
		while (!q.isEmpty()) {
			GNode cur = q.poll();
			closed.add(cur);
			sb.append(cur.dataToString()).append(IGraph.NODE_DELIMIT);
			
			for (GNode neigh: cur.neighbors) {
				if (!closed.contains(neigh)) {
					q.offer(neigh);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		return toStringBfs();
	}
	public static void main(String[] args) {
		IGraph<String> g = new DirectedGraph<String>();
		g.addData("a");
		g.addData("b");
		g.addData("c");
		g.addData("d");
		
		g.addEdge("a", "b");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "a");
		
		System.out.println(g.toStringBfs());
	}
}
