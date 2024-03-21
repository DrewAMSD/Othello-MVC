package mvc.othello;

import com.mrjaffesclass.apcs.messenger.*;
import java.util.ArrayList;

/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;

  // Model's data variables
  private int[][] board;
  private ArrayList<Coordinate> legalMoves;
  private int gameStatus;
  private int whoseMove;
  private int blackPieces;
  private int whitePieces;

  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    this.mvcMessaging = messages;
    this.board = new int[8][8];
    this.legalMoves = new ArrayList<>();
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
    //subscribe to messages here
    this.mvcMessaging.subscribe("view:btnClicked", this);
    this.mvcMessaging.subscribe("view:newGame", this);
    
    this.newGame();
  }
  
    /**
   * Reset the state for a new game
   */
  private void newGame() {
    // starting board state
    for (int row = 0; row < Constants.BOARD_SIZE; row++) {
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            if ((row==3 && col==3) || (row==4 && col==4)) {
                board[row][col] = Constants.WHITE;
            } else if ((row==3 && col==4) || (row==4 && col==3)) {
                board[row][col] = Constants.BLACK;
            } else board[row][col] = Constants.EMPTY;
        }
    }
    
    this.gameStatus = Constants.IN_PLAY;
    this.whoseMove = Constants.BLACK;
    this.legalMoves.clear();
    
    this.legalMoves.add(new Coordinate(2, 3));
    this.legalMoves.add(new Coordinate(3, 2));
    this.legalMoves.add(new Coordinate(4, 5));
    this.legalMoves.add(new Coordinate(5, 4));
    
    this.whitePieces = 2;
    this.blackPieces = 2;
    
    
    this.mvcMessaging.notify("model:boardChanged", this.board);
    this.mvcMessaging.notify("model:legalMovesChanged", this.legalMoves);
    this.mvcMessaging.notify("model:piecesChanged", new Coordinate(blackPieces, whitePieces));
    this.mvcMessaging.notify("model:moveChanged", this.whoseMove);
  }
  
    private void flipTiles(Coordinate direction, Coordinate curLocation) {
        boolean moving = true;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                break;
            }
            int curRow = curLocation.getRow();
            int curCol = curLocation.getCol();
            if (board[curRow][curCol] == this.whoseMove) {
                break;
            }
            board[curRow][curCol] = this.whoseMove;
        }
    }
    
    private void flipOpposingTiles(Coordinate moveMade) {
        for (Coordinate direction : Constants.DIRECTIONS) {
            Coordinate curLocation = new Coordinate(moveMade.getRow(), moveMade.getCol());
            if (this.checkDirection(direction, curLocation)) {
                Coordinate tempMoveMade = new Coordinate(moveMade.getRow(), moveMade.getCol());
                this.flipTiles(direction, tempMoveMade);
            }
        }
    }
  
    private void countPieces() {
        int black = 0;
        int white = 0;
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                if (board[row][col] == Constants.BLACK) {
                    black++;
                } else if (board[row][col] == Constants.WHITE) {
                    white++;
                }
            }
        }
        this.blackPieces = black;
        this.whitePieces = white;
    }
  
    private void updateBoardAndPiecesUI() {
        this.mvcMessaging.notify("model:boardChanged", this.board);
        this.mvcMessaging.notify("model:piecesChanged", new Coordinate(blackPieces, whitePieces));
    }
    
    private boolean checkDirection(Coordinate direction, Coordinate curLocation) {
        boolean moving = true;
        boolean isOppositeTile = false;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                return false;
            }
            int curTile = board[curLocation.getRow()][curLocation.getCol()];
            if (curTile == this.whoseMove * -1) {
                isOppositeTile = true;
            } else if (curTile == this.whoseMove) {
                break;
            } else {
                return false;
            }
        }
        return isOppositeTile;
        
    }
    
    private boolean isLegalMove(Coordinate possibleMove) {
        for (Coordinate direction : Constants.DIRECTIONS) {
            Coordinate tempMove = new Coordinate(possibleMove.getRow(), possibleMove.getCol());
            if (this.checkDirection(direction, tempMove)) {
                return true;
            }
        }
        return false;
    }
    
    private ArrayList<Coordinate> getLegalMoves() {
        ArrayList<Coordinate> newLegalMoves = new ArrayList<>();
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                Coordinate possibleMove = new Coordinate(row, col);
                if (board[possibleMove.getRow()][possibleMove.getCol()] == Constants.EMPTY && isLegalMove(possibleMove)) {
                    newLegalMoves.add(possibleMove);
                }
            }
        }
        return newLegalMoves;
    }
    
    private int getWinner() {
        if (blackPieces > whitePieces) {
            return Constants.BLACK_WINS;
        }
        if (blackPieces < whitePieces) {
            return Constants.WHITE_WINS;
        }
        return Constants.DRAW;
    }
    
    private void changeTurnAndCheckForWinner(){
        this.whoseMove = this.whoseMove * -1;
        this.legalMoves = getLegalMoves();
        if (this.legalMoves.isEmpty()) {
            this.whoseMove = this.whoseMove * -1;
            this.legalMoves = getLegalMoves();
            if (this.legalMoves.isEmpty()) {
                this.gameStatus = this.getWinner();
            }
        }
    }
    
    private void updateGameStatusUI() {
        if (gameStatus == Constants.IN_PLAY) {
            this.mvcMessaging.notify("model:legalMovesChanged", this.legalMoves);
            this.mvcMessaging.notify("model:moveChanged", this.whoseMove);
        } else {
            this.mvcMessaging.notify("model:gameOver", this.gameStatus);
        }
    }
    

    public void makeMove(Coordinate moveMade) {
        //move is a legal move, place tile into move coordinate
        this.board[moveMade.getRow()][moveMade.getCol()] = this.whoseMove;
        
        //step into every direction and flip tiles in between move and a tile from whoseMove if every tile in between is the opposing players tile
        this.flipOpposingTiles(moveMade);
        
        //count new pieces on the board
        this.countPieces();
        
        //update ui of placed board and pieces
        this.updateBoardAndPiecesUI();
        
        //change player, check for new legal moves, if none, back to other player, if also none gameOver(determine winner or draw), if either have moves, then continue
        this.changeTurnAndCheckForWinner();
        
        //update ui based on current game state
        this.updateGameStatusUI();
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
        switch (messageName) {
            case "view:btnClicked": {
                if (gameStatus == Constants.IN_PLAY) {
                    Coordinate moveMade = (Coordinate) messagePayload;
                    for (Coordinate legalMove : legalMoves) {
                        if (moveMade.isEqualTo(legalMove)) {
                            makeMove(moveMade);
                            break;
                        }
                    }
                }
                
                break;
            }
            
            case "view:newGame": {
                this.newGame();
                
                break;
            }

            default: {
                break;
            }
        }
    }
}
