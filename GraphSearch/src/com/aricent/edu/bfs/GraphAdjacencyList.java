package com.aricent.edu.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphAdjacencyList {

	private static Map<Integer, List<Vertex>>  graphadjacencyList = null;

	public GraphAdjacencyList(int number_of_vertices){
		
		graphadjacencyList = new HashMap<Integer, List<Vertex>>();
		for(int i = 1; i <= number_of_vertices;i++){
			graphadjacencyList.put(i, new LinkedList<Vertex>());
		}
	}
	public Map<Integer, List<Vertex>> getAdjacencyList() {
		return graphadjacencyList;
	}
	public void setAdjacencyList(Map<Integer, List<Vertex>> graphadjacencyList) {
		this.graphadjacencyList = graphadjacencyList;
	}
	
	public void addEdge(Vertex u , Vertex v){
		if(u.getKey() > graphadjacencyList.size() || v.getKey() > graphadjacencyList.size()){
			System.out.println("Given vertex is out of vertex Range");
			return;
		}
		List<Vertex> listofVerticesSource = graphadjacencyList.get(u.getKey());
		listofVerticesSource.add(v);
//		List<Vertex> listofVerticesDestination = graphadjacencyList.get(v.getKey());
//		listofVerticesDestination.add(u);
	}
	public List<Vertex> getEdge(Vertex u){
		if(u.getKey() > graphadjacencyList.size()){
			System.out.println("Given vertex not present in Graph");
			return null;
		}
		return graphadjacencyList.get(u.getKey());
	}
	public static void main(String[] args) {
		GraphAdjacencyList graph = new GraphAdjacencyList(5);
		Vertex u = new Vertex("white", null, 0, 1);
		Vertex v = new Vertex("white", null, 0, 2);
		Vertex w = new Vertex("white", null, 0, 3);
		Vertex x = new Vertex("white", null, 0, 4);
		Vertex y = new Vertex("white", null, 0, 5); 
		graph.addEdge(u, v);
		graph.addEdge(u, w);
		graph.addEdge(v, w);
		graph.addEdge(v, x);
		graph.addEdge(v, y);
		graph.addEdge(w, x);
		graph.addEdge(x, y);
		
		Set<Integer> vertices = graphadjacencyList.keySet();
		for(Integer vertex  : vertices){
			System.out.println();
			List<Vertex> list = graphadjacencyList.get(vertex);
			System.out.print(vertex+"->");
			for(Vertex ver:list){
				System.out.print(ver.getKey()+"->");
			}
		}
		
	}
}
