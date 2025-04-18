/**
* MazeSquare represents a single square within a Maze.
* @author Anna Rafferty
* @author Anya Vostinar
*/ 
public class MazeSquare {
    //Wall variables
    private boolean hasTopWall = false;
    private boolean hasRightWall = false;

    //Other variables
    private boolean visited = false;
    private boolean solutionPiece = false;
		
    //Location of this square in a larger maze.
    private int row;
    private int col;
		
    public MazeSquare(boolean top, boolean right, int r, int c) {
      hasTopWall = top;
      hasRightWall = right;
      row = r;
      col = c;
    }
		
    /**
     * See if the square has a top wall
     * @return true if the maze square has a top wall, false if not
     */
    public boolean hasTopWall() {
        return hasTopWall;
    }
		
    /**
     * See if the square has a right wall
     * @return true if the maze square has a right wall, false if not
     */
    public boolean hasRightWall() {
        return hasRightWall;
    }
		
    /**
     * Get the row that the maze square is in
     * @return integer value of row 
     */
    public int getRow() {
        return row;
    }
		
    /**
     * Get the column that the maze square is in
     * @return integer value of column
     */
    public int getColumn() {
        return col;
    }

    /**
     * Set the square to visited
     */
    public void setVisited() {
      visited = true;
    }

    /**
     * Set the square to unvisited
     */
    public void setUnvisited() {
      visited = false;
    }

    /**
     * See if the square has been visited before
     * @return true if the square has been visited before, false if not
     */
    public boolean getVisited() {
      return visited;
    }

    /**
     * See if the square is part of the solution
     * @return true if it is, false if not
     */
    public boolean getSolutionPiece() {
      return solutionPiece;
    }

    /**
     * Setting the square's status to a part of the solution, which is a solution piece
     */
    public void setSolutionPiece() {
      solutionPiece = true;
    }

    /**
     * Reset the square's status to not a solution piece
     */
    public void resetSolutionPiece() {
      solutionPiece = false;
    }
    
    
} 