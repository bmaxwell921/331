package edu.iastate.cs331.common;

/**
 * An interface representing behaviors for graph datastructures
 * @author brandon
 *
 * @param <D>
 * 				The generic type of data to be added to the graph
 * @param <E>
 * 				
 */
public interface IGraph<D> {
	
	/**
	 * Adds the given data to the graph, leaving it unconnected. If the data
	 * already exists in the graph this method will return false, otherwise it 
	 * returns true.
	 * @param data
	 * 				The data to add to the graph
	 * @return
	 * 			True or false based on whether the data was added to the graph or not
	 */
	public boolean addData(D data);
	
	/**
	 * Adds an edge from one data point to another. If either of the data points
	 * did not exist before this method was called, they will be created and added.
	 * If an edge already existed between from from to to, this method will return false.
	 * @param from
	 * @param to
	 * @return
	 */
	public boolean addEdge(D from, D to);
	
	public int size();
	
	public String toStringDfs();
	
	public String toStringBfs();
}
