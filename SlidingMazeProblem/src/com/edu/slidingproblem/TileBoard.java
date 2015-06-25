package com.edu.slidingproblem;
import java.util.*;

public class TileBoard
{
	//String representation of the solution board
	private static final String goalBoard = "123456780";

	//String representation of a puzzle board
	private String myBoard;

	//Represents Parent Board in Tree
	private TileBoard parentBoard;
	
	//String representation of the list of moves that generated this board
	private String myMoves;

	private List<TileBoard> listofNextBoards;
	//int representation to store Manhattan distance
	
	private int manHattanDistance = -1;
	/* You may add more attributes and methods as you see fit */

	public TileBoard(String board)
	{
		this.myBoard = board;
		listofNextBoards = new ArrayList<TileBoard>();
		/* Your code goes here */
	}

	/*
	 * Returns a list of boards that are one move away.  This list *DOES NOT* contain the
	 * previous board, as this would undo a moving we just made
	 */
	public List<TileBoard> getNextBoards(TileBoard b)
	{
		/* Your code goes here */
		return listofNextBoards;
	}
	/***
	 * 
	 * @param b
	 * @return
	 */
	public void setNextBoards(TileBoard b)
	{
		/* Your code goes here */
		this.listofNextBoards.add(b);
	}
	/*
	 * Returns the number of moves from the initial board
	 */
	public static int getNumMoves(TileBoard b)
	{
		return b.myMoves.length();
	}

	/*
	 * Evaluates the given board using the Manhattan distance heuristic.
	 */
	public static int calcManhattanDistance(TileBoard b)
	{
		/* Your code goes here */
		return -1;
	}
}
