package edu.iastate.cs331.common;

/**
 * An interface representing behaviors for graph datastructures
 * @author brandon
 *
 * @param <E>
 * 				The generic type of data to be added to the graph 				
 */
public interface IGraph<E> {
	public static final String NODE_DELIMIT = ",";
	
	/**
	 * Adds the given data to the graph, leaving it unconnected. If the data
	 * already exists in the graph this method will return false, otherwise it 
	 * returns true.
	 * @param data
	 * 				The data to add to the graph
	 * @return
	 * 			True or false based on whether the data was added to the graph or not
	 */
	public boolean addData(E data);
	
	/**
	 * Adds an edge from one data point to another. If either of the data points
	 * do not exist, the method will return false and exit.
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean addEdge(E from, E to);
	
	/**
	 * Returns the number of nodes in the graph
	 * @return
	 */
	public int size();
	
	/**
	 * Returns the string representation of the nodes in the graph, following
	 * the depth first order
	 * @return
	 */
	public String toStringDfs();
	
	/**
	 * Returns the string representation of the nodes in the graph, following
	 * the breadth first order
	 * @return
	 */
	public String toStringBfs();
}
