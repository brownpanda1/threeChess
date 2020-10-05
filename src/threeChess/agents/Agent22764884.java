package threeChess.agents;

import threeChess.*;
import java.util.Random;



public class Agent22764884 extends Agent{
	private static final String name = "22764884";
	private static final Random random = new Random();
	
	
	public Agent22764884() {}
	
	@Override
	public Position[] playMove(Board board) {
		int moveCount = board.getMoveCount();
		if(moveCount > 0) {
			Position[] lastMove = board.getMove(moveCount-1);
			try {
				Position start = Position.get(Colour.values()[(lastMove[0].getColour().ordinal()+1)%3], lastMove[0].getRow(), lastMove[0].getColumn());
				Position end = Position.get(Colour.values()[(lastMove[0].getColour().ordinal()+1)%3], lastMove[1].getRow(), lastMove[1].getColumn());
				if(board.isLegalMove(start, end))return new Position[] {start, end};
			}
			catch(ImpossiblePositionException e) {}
		}
		Position[] pieces = board.getPositions(board.getTurn()).toArray(new Position[0]);
		Position start = pieces[0];
	    Position end = pieces[0]; //dummy illegal move
	    while (!board.isLegalMove(start, end)){
	      start = pieces[random.nextInt(pieces.length)];
	      Piece mover = board.getPiece(start);
	      Direction[][] steps = mover.getType().getSteps();
	      Direction[] step = steps[random.nextInt(steps.length)];
	      int reps = 1 + random.nextInt(mover.getType().getStepReps());
	      end = start;
	      try{
	        for(int i = 0; i<reps; i++)
	          end = board.step(mover, step, end, start.getColour()!=end.getColour());
	      }catch(ImpossiblePositionException e){}
	    }
	    return new Position[] {start,end};
	  }
	
	/**
	 * @return the Agent's name, for annotating game description.
	 */
	public String toString() {return name;}

	@Override
	public void finalBoard(Board finalBoard) {}

}
