package mvc.tictactoe;

import com.mrjaffesclass.apcs.messenger.*;

/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;

  // Model's data variables
  private boolean whoseMove;
  private boolean gameOver;
  private String[][] board;

  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    mvcMessaging = messages;
    this.board = new String[3][3];
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    this.newGame();
    this.mvcMessaging.subscribe("playerMove", this);
    this.mvcMessaging.subscribe("newGame", this);
  }
  
    /**
   * Reset the state for a new game
   */
  private void newGame() {
    for(int row=0; row<this.board.length; row++) {
      for (int col=0; col<this.board[0].length; col++) {
        this.board[row][col] = "";
      }
    }
    this.whoseMove = false;
    this.gameOver = false;
  }

  private String isWinner(String player) {

        
        String winner = "";
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (step(1, 0, row, col, 0, player)
                    || step(0, 1, row, col, 0, player)
                    || step(1, 1, row, col, 0, player)
                    || step(-1, 1, row, col, 0, player) )
                {
                    winner = player;
                    break;
                }
            }
            if (!winner.equals("")) break;
        }
        //a player has won or check for if the game has drawed
        return winner;
    }

    public boolean step(int stepR, int stepC, int row, int col, int count, String curTile) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;
        if (board[row][col].equals(curTile))  {
            count++;
        } else {
            return false;
        }
        if (count==3) return true;
        if (step(stepR, stepC, row+stepR, col+stepC, count, curTile)) return true;
        
        return false;
    }
    
    private boolean checkForDraw() {
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    // Display the message to the console for debugging
    if (messagePayload != null) {
      System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by model: "+messageName+" | No data sent");
    }
    
    // playerMove message handler
    if (messageName.equals("playerMove")) {
      // Get the position string and convert to row and col
      String position = (String)messagePayload;
      Integer row = new Integer(position.substring(0,1));
      Integer col = new Integer(position.substring(1,2));

      // If square is blank...
      if (this.board[row][col].equals("") && !gameOver) {
        // ... then set X or O depending on whose move it is
        if (this.whoseMove) {
          this.board[row][col] = "X";
        } else {
          this.board[row][col] = "O";
        }
        String player = (this.whoseMove) ? "X" : "O";
        String winner = isWinner(player);
            if (!winner.equals("")) {
                this.mvcMessaging.notify("gameWon", player);
                this.gameOver = true;
            } else {
                boolean draw = checkForDraw();
                if (draw) {
                    this.mvcMessaging.notify("draw", "");
                    this.gameOver = true;
                }
            }
        this.whoseMove = !this.whoseMove;
        mvcMessaging.notify("turnChanged", (this.whoseMove) ? "X" : "O");
        // Send the boardChange message along with the new board 
        this.mvcMessaging.notify("boardChange", this.board);
      }
      
    // newGame message handler
    } else if (messageName.equals("newGame")) {
      // Reset the app state
      this.newGame();
      // Send the boardChange message along with the new board 
      this.mvcMessaging.notify("boardChange", this.board);
    }
  }



}
