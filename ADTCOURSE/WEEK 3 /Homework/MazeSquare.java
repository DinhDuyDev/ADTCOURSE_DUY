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
     * Insert documentation here!
     */
    public boolean hasTopWall() {
        return hasTopWall;
    }
		
    /**
     * Insert documentation here!
     */
    public boolean hasRightWall() {
        return hasRightWall;
    }
		
    /**
     * Insert documentation here!
     */
    public int getRow() {
        return row;
    }
		
    /**
     * Insert documentation here!
     */
    public int getColumn() {
        return col;
    }

    /**
     * Insert documentation here!
     */
    public void setVisited() {
      visited = true;
    }

    /**
     * Insert documentation here!
     */
    public void setUnvisited() {
      visited = false;
    }

    /**
     * Insert documentation here!
     */
    public boolean getVisited() {
      return visited;
    }

    /**
     * Insert documentation here!
     */
    public boolean getSolutionPiece() {
      return solutionPiece;
    }

    /**
     * Insert documentation here!
     */
    public void setSolutionPiece() {
      solutionPiece = true;
    }

    /**
     * Insert documentation here!
     */
    public void resetSolutionPiece() {
      solutionPiece = false;
    }
    
    
} 