package com.aricent.edu.bfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	private static GraphAdjacencyList graphAdjacencyList = null;
	private static int time = 0;
	public DFS(GraphAdjacencyList graphAdjacencyList){
		this.graphAdjacencyList = graphAdjacencyList;
	}
	public void dfsSearch(List<Vertex> graphVertices){
		for(Vertex u:graphVertices){
			if(u.getColour().equalsIgnoreCase(GraphConstants.WHITE_COLOUR)){
				dfsVisit(u);
			}
		}
	}
	public void dfsVisit(Vertex u){
		time = time + 1;
		u.setDiscoveryTime(time);
		u.setColour(GraphConstants.GRAY_COLOUR);
		List<Vertex> adjacentvertices = graphAdjacencyList.getEdge(u);
		for(Vertex v : adjacentvertices){
			if(v.getColour().equalsIgnoreCase(GraphConstants.WHITE_COLOUR)){
				v.setColour(GraphConstants.GRAY_COLOUR);
				v.setPredecessor(u);
				dfsVisit(v);
			}
		}
		System.out.println(u.getKey()+"->");
		time = time + 1;
		u.setFinishingTime(time);
		u.setColour(GraphConstants.BLACK_COLOUR);
	}
	public static void main(String[] args) {
		GraphAdjacencyList graph = new GraphAdjacencyList(10);
		List<Vertex> listofvertices = new ArrayList<Vertex>();
		Vertex a = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 1);
		listofvertices.add(a);
		Vertex b = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 2);
		listofvertices.add(b);
		Vertex c = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 3);
		listofvertices.add(c);
		Vertex d = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 4);
		listofvertices.add(d);
		Vertex e = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 5); 
		listofvertices.add(e);
		Vertex f = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 6); 
		listofvertices.add(f);
		Vertex g = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 7); 
		listofvertices.add(g);
		Vertex h = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 8); 
		listofvertices.add(h);
		Vertex i = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 9);
		listofvertices.add(i);
		Vertex j = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 10); 
		listofvertices.add(j);
		

		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(a, d);
		graph.addEdge(b, e);
		graph.addEdge(b, f);
		graph.addEdge(c, g);
		graph.addEdge(c, h);
		graph.addEdge(d, i);
		graph.addEdge(d, j);
		
		
		DFS dfs =  new DFS(graph);
		dfs.dfsSearch(listofvertices);
	}
}
