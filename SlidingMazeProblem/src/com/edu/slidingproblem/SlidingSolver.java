package com.edu.slidingproblem;
import java.util.*;

public class SlidingSolver
{
	private static final int MAX_DISTANCE = 20;

	private String initialBoard;
	/* You may add instance and class variables and methods as you see fit */

	/*
	 * Constructs a SlidingSolver with the given input board.
	 */
	public SlidingSolver(String initialBoard)
	{
		this.initialBoard = initialBoard;
		/* Your code here */
	}

	/*
	 * Solves the puzzle by performing an A* search over the puzzle space.
	 */
	public SlidingSolution solvePuzzleAStar()
	{
		/* Your code here */
		TileBoard tileBoard = new TileBoard(initialBoard);
		tileBoard.setNextBoards(tileBoard);
	
		for(int i = 0;i < initialBoard.length();i++){
			if('0' == initialBoard.charAt(i)){
				
			}
		}
		return SlidingSolution.NO_RESPONSE;
	}
	public List<String> possibleNextBoards(String inputBoard,int index){
		List<String> listofPossibleBoards  = new ArrayList<String>();
		
		return listofPossibleBoards;
	}
	public String swap(String inputBoard,int i,int j){
		List<String> listofPossibleBoards  = new ArrayList<String>();
	    StringBuilder sb = new StringBuilder(inputBoard);
	   char l = sb.charAt(i), r = sb.charAt(j);
	   sb.setCharAt(i, r);
	   sb.setCharAt(j, l);
	   listofPossibleBoards.add(sb.toString());
	   return sb.toString();
	}
	/*
	 * Evaluates the given board.
	 */
	private int evaluateHeuristic(TileBoard p)
	{
		return TileBoard.getNumMoves(p) + TileBoard.calcManhattanDistance(p);
	}

	class TileBoardComparator implements Comparator<TileBoard>
	{
		public int compare(TileBoard a, TileBoard b)
		{
			/* Your code here */
			
			return 0;
		}
	}
	public static void main(String[] args) {
		SlidingSolver slidingSolver = new SlidingSolver("PRAVESHA");
		slidingSolver.swap("PRAVESHA",2, 4);
		System.out.println(slidingSolver.initialBoard);
	}
}
