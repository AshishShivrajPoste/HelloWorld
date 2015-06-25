package com.aricent.edu.bfs;

public class Vertex {

	private String colour = null;
	private Vertex predecessor = null;
	private int distance;
	private Integer key  = null;
	private int discoveryTime;
	private int finishingTime;
	
	public Vertex(){}
	
	public Vertex(String colour,Vertex predecessor,int distance,int key){
		this.colour = colour;
		this.predecessor = predecessor;
		this.distance = distance;
		this.key = key;
	}
	public String getColour() {
		return this.colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public Vertex getPredecessor() {
		return this.predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}
	public int getDistance() {
		return this.distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Integer getKey() {
		return this.key;
	}
	public void setKey(Integer key) {
		this.key = key;
	}
	public int getDiscoveryTime() {
		return discoveryTime;
	}
	public void setDiscoveryTime(int discoveryTime) {
		this.discoveryTime = discoveryTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	
}
