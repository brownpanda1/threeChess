package threeChess.agents;

import threeChess.*;
import java.util.ArrayList;



public class Agent22764884 extends Agent{
	private static final String name = "22764884";
	
	
	public Agent22764884() {}

	public Position[][] nextMoves(Board board) {
	// Find all of our piece positions and all of the board nextPositions
    	Position[] pieces = board.getPositions(board.getTurn()).toArray(new Position[0]);
    	Position[] next = Position.values();
    	ArrayList<Position[]> nextMoves = new ArrayList<>();
    	for (Position piece : pieces) {
    	for (Position positions : next) {
    		// Move piece to position and test if legal
    		Position[] move = new Position[] {piece, positions};
        	if (board.isLegalMove(piece, positions) && !nextMoves.contains(move)) nextMoves.add(move);
      		}
    	}
    
	return nextMoves.toArray(new Position[0][0]);
	}
	
	@Override
	public Position[] playMove(Board board) {
		
		//Copy of current board
		Board copy = board;
		
		//Find all possible next moves
		Position[][] next = nextMoves(copy);
		
		//Perform MCTS
		
		
	}
	
	/**
	 * @return the Agent's name, for annotating game description.
	 */
	public String toString() {return name;}

	@Override
	public void finalBoard(Board finalBoard) {}
}
