package com.aricent.edu.bfs;

import java.util.List;
import java.util.Map;

import com.aricent.edu.queue.QueueLinkedList;

public class BFS {

	private QueueLinkedList<Vertex> queue = null;
	private GraphAdjacencyList graphAdjacencyList = null;
	
	public BFS(GraphAdjacencyList graphAdjacencyList){
		queue = new QueueLinkedList<Vertex>();
		this.graphAdjacencyList = graphAdjacencyList;
	}
	public void bfs(Vertex source){
		source.setDistance(0);
		source.setColour(GraphConstants.GRAY_COLOUR);
		source.setPredecessor(null);
		System.out.println(source.getKey());
		queue.enqueue(source);
		int level = 0;
		while(!queue.isEmpty()){
			Vertex u = queue.dequeue();
			List<Vertex> listofVertex = graphAdjacencyList.getEdge(u);
			System.out.println();
			for(Vertex vertex : listofVertex){
				if(vertex.getColour().equalsIgnoreCase(GraphConstants.WHITE_COLOUR))
				{
					System.out.print(" "+vertex.getKey());
					vertex.setColour(GraphConstants.GRAY_COLOUR);
					vertex.setDistance(u.getDistance()+1);
					vertex.setPredecessor(u);
					queue.enqueue(vertex);
				}
			}
			u.setColour(GraphConstants.BLACK_COLOUR);
		}
	}
	public void printPath(Vertex s, Vertex v){
		if(s == v){
			System.out.print(s.getKey()+"->");
		}else if(null == v.getPredecessor()){
			System.out.println("THERE EXISTS NO PATH FROM S TO V");
		}else{
			printPath(s, v.getPredecessor());
			System.out.print(v.getKey()+"->");
			
		}
	}
	public static void main(String[] args) {
		GraphAdjacencyList graph = new GraphAdjacencyList(10);
		Vertex a = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 1);
		Vertex b = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 2);
		Vertex c = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 3);
		Vertex d = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 4);
		Vertex e = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 5); 
		Vertex f = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 6); 
		Vertex g = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 7); 
		Vertex h = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 8); 
		Vertex i = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 9);
		Vertex j = new Vertex(GraphConstants.WHITE_COLOUR, null, 0, 10); 
		graph.addEdge(a, b);
		graph.addEdge(a, c);
		graph.addEdge(a, d);
		graph.addEdge(b, e);
		graph.addEdge(b, f);
		graph.addEdge(c, g);
		graph.addEdge(c, h);
		graph.addEdge(d, i);
		graph.addEdge(d, j);
		
		BFS bfs = new BFS(graph);
		bfs.bfs(a);
		bfs.printPath(g, d);
	}
}
