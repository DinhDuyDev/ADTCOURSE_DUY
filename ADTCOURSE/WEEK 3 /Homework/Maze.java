import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Insert Documentation here!
*
*/
public class Maze { 
    //Number of rows in the maze.
    private int numRows;
    
    //Number of columns in the maze.
    private int numColumns;
    
    //Grid coordinates for the starting maze square
    private int startRow;
    private int startColumn;
    
    //Grid coordinates for the final maze square
    private int finishRow;
    private int finishColumn;
    
    //A double array of the MazeSquares in the maze
    MazeSquare[][] squares;
    
    /**
     * Creates an empty maze with no squares.
     */
    public Maze() {
    } 
    
    /**
     * Load a .txt file and constructing a maze out of the file
     * @param fileName String value for the path of the file
     */
    public boolean load(String fileName) { 
      File inputFile = new File(fileName);
      Scanner scanner = null;
      try {
        scanner = new Scanner(inputFile);
      } catch (FileNotFoundException e) {
        System.err.println(e);
        System.exit(1);
      }

      numRows = Integer.parseInt(scanner.next());
      numColumns = Integer.parseInt(scanner.next());
      squares = new MazeSquare[numRows][numColumns];
      startRow = Integer.parseInt(scanner.next());
      startColumn = Integer.parseInt(scanner.next());
      finishRow = Integer.parseInt(scanner.next());
      finishColumn = Integer.parseInt(scanner.next());

      for(int i=0; i<numRows; i++){
        String linecode = scanner.next();
        for (int j=0; j<numColumns; j++) {
          String code = linecode.substring(j,j+1);
          if(code.equals("7")){
            squares[i][j] = new MazeSquare(true, true, i, j);
          } else if(code.equals("|")) {
            squares[i][j] = new MazeSquare(false, true, i, j);
          } else if(code.equals("_")) {
            squares[i][j] = new MazeSquare(true, false, i, j);
          } else if(code.equals("*")) {
            squares[i][j] = new MazeSquare(false, false, i, j);
          } else {
            return false;
          }
          
        }
      }
      

      return true;
    }  
    
    /**
     * Printing out the solution of the maze
     * @param solution boolean value to decide whether to print out the results
     */
    public void print(boolean solution) {
        //We'll print off each row of squares in turn.
        for(int row = 0; row < numRows; row++) {
            
            //Print each of the lines of text in the row
            for(int charInRow = 0; charInRow < 4; charInRow++) {
                //Need to start with the initial left wall.
                if(charInRow == 0) {
                    System.out.print("+");
                } else {
                    System.out.print("|");
                }
                
                for(int col = 0; col < numColumns; col++) {
                    MazeSquare curSquare = this.getMazeSquare(row, col);
                    if(charInRow == 0) {
                        //We're in the first row of characters for this square - need to print
                        //top wall if necessary.
                        if(curSquare.hasTopWall()) {
                            System.out.print(getTopWallString());
                        } else {
                            System.out.print(getTopOpenString());
                        }
                    } else if(charInRow == 1 || charInRow == 3) {
                        //These are the interior of the square and are unaffected by
                        //the start/final state.
                        if(curSquare.hasRightWall()) {
                            System.out.print(getRightWallString());
                        } else {
                            System.out.print(getOpenWallString());
                        }
                    } else {
                        //We must be in the second row of characters.
                        //This is the row where start/finish should be displayed if relevant
                        
                        //Check if we're in the start or finish state
                        if(startRow == row && startColumn == col) {
                            System.out.print("  S  ");
                        } else if(finishRow == row && finishColumn == col) {
                            System.out.print("  F  ");
                        } else if(curSquare.getSolutionPiece() && solution) {
                          System.out.print("  *  ");
                        } else {
                            System.out.print("     ");
                        }
                        if(curSquare.hasRightWall()) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    } 
                }
                
                //Now end the line to start the next
                System.out.print("\n");
            }           
        }
        
        //Finally, we have to print off the bottom of the maze, since that's not explicitly represented
        //by the squares. Printing off the bottom separately means we can think of each row as
        //consisting of four lines of text.
        printFullHorizontalRow(numColumns);
    }
    
    /**
     * Prints the very bottom row of characters for the bottom row of maze squares (which is always walls).
     * numColumns is the number of columns of bottom wall to print.
     */
    private static void printFullHorizontalRow(int numColumns) {
        System.out.print("+");
        for(int row = 0; row < numColumns; row++) {
            //We use getTopWallString() since bottom and top walls are the same.
            System.out.print(getTopWallString());
        }
        System.out.print("\n");
    }
    
    /**
     * Returns a String representing the bottom of a horizontal wall.
     */
    private static String getTopWallString() {
        return "-----+";
    }
    
    /**
     * Returns a String representing the bottom of a square without a
     * horizontal wall.
     */
    private static String getTopOpenString() {
        return "     +";
    }
    
    /**
     * Returns a String representing a left wall (for the interior of the row).
     */
    private static String getRightWallString() {
        return "     |";
    }
    
    /**
     * Returns a String representing no left wall (for the interior of the row).
     */
    private static String getOpenWallString() {
        return "      ";
    }
    
    /**
     * Get the instance of the maze square object at given coordinates
     * @param row row of the maze to take the maze square object
     * @param col col of the maze to take the maze square object
     */
    public MazeSquare getMazeSquare(int row, int col) {
        return squares[row][col];
    }

    private boolean leftAccessible(int x, int y) {
      if (x-1 >= 0) {
        MazeSquare leftSquare = this.getMazeSquare(y, x-1);
        if (!leftSquare.hasRightWall() && !leftSquare.getVisited()) {
          return true;
        }
      }
      return false;
    }

    private boolean rightAccessible(int x, int y) {
      if (x+1 <= numColumns-1) {
        MazeSquare rightSquare = this.getMazeSquare(y, x);
        MazeSquare toRight = this.getMazeSquare(y, x+1);
        if (!rightSquare.hasRightWall() && !toRight.getVisited()) {
          return true;
        }
      }
      return false;
    }

    private boolean topAccessible(int x, int y) {
      if (y-1 >= 0) {
        MazeSquare topSquare = this.getMazeSquare(y, x);
        MazeSquare toTop = this.getMazeSquare(y-1, x);
        if (!topSquare.hasTopWall() && !toTop.getVisited()) {
          return true;
        }
      }
      return false;
    }

    private boolean downAccessible(int x, int y) {
      if (y+1 <= numRows-1) {
        MazeSquare downSquare = this.getMazeSquare(y+1, x);
        if (!downSquare.hasTopWall() && !downSquare.getVisited()) {
          return true;
        }
      }
      return false;
    }

    /**
    * Calculating the steps needed to find the finish square
    */
    public Stack<MazeSquare> getSolution() {
      LinkedStack<MazeSquare> solution = new LinkedStack<MazeSquare>();
      MazeSquare start = this.getMazeSquare(startRow, startColumn);
      int startX = startColumn;
      int startY = startRow;
      solution.push(start);
      start.setVisited();
      while (!solution.isEmpty()) {
        if (solution.peek().getColumn() == finishColumn && solution.peek().getRow() == finishRow) {
          break;
        } else {
          if (this.leftAccessible(startX, startY)) {
            MazeSquare block = this.getMazeSquare(startY, startX-1);
            solution.push(block);
            block.setVisited();
            startX--;
          } else if (this.rightAccessible(startX, startY)) {
            MazeSquare block = this.getMazeSquare(startY, startX+1);
            solution.push(block);
            block.setVisited();
            startX++;
          } else if (this.topAccessible(startX, startY)) {
            MazeSquare block = this.getMazeSquare(startY-1, startX);
            solution.push(block);
            block.setVisited();
            startY--;
          } else if (this.downAccessible(startX, startY)) {
            MazeSquare block = this.getMazeSquare(startY+1, startX);
            solution.push(block);
            block.setVisited();
            startY++;
          } else {
            solution.pop();
            if (!solution.isEmpty()) {
              startX = solution.peek().getColumn();
              startY = solution.peek().getRow();
            } else {
              break;
            }
          }
        }
      }
      if (solution.isEmpty()) {
        System.err.println("Maze is impossible to solve");
      }
      return solution;
    }
    
 
    /**
     * main function to provide user interactibility. Has two modes: --solution and nothing.
     * --solution returns the solution for the maze
     * nothing returns the maze itself
     */ 
    public static void main(String[] args) {
      if(args.length == 1) {
        Maze myMaze = new Maze();
        myMaze.load(args[0]);
        myMaze.print(false);
      } else {
        Maze myMaze = new Maze();
        LinkedStack<MazeSquare> mazeSolution;
        myMaze.load(args[0]);
        if (args[1].equals("--solution")) {
          mazeSolution = (LinkedStack<MazeSquare>) myMaze.getSolution();
          MazeSquare square;
          while (!mazeSolution.isEmpty()) {
            square = mazeSolution.pop();
            square.setSolutionPiece();
          }
          myMaze.print(true);
        }
      }
    } 
}