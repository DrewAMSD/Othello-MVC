/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.othello;

import java.util.ArrayList;
/**
 *
 * @author drewam
 */
public class AIPlayer {
    private int color;
    private String difficulty;
    
    public AIPlayer(int playerColor, String playerDifficulty) {
        this.color = playerColor;
        this.difficulty = playerDifficulty;
    }
    
    public Coordinate getMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        switch (this.difficulty) {
            case Constants.AI_EASY: 
                return getEasyMove(board, legalMoves);
            case Constants.AI_MEDIUM:
                return getMediumMove(board, legalMoves);
            case Constants.AI_HARD:
                return getHardMove(board, legalMoves);
            case Constants.AI_EXTREME:
                return getExtremeMove(board, legalMoves);
            default:
                break;
        }
        return null;
    }
    
    private int[][] cloneBoard(int[][] board) {
        int[][] cloneBoard = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                cloneBoard[row][col] = board[row][col];
            }
        }
        return cloneBoard;
    }
    
    private boolean checkDirectionAI(int[][] board, Coordinate direction, Coordinate curLocation) {
        boolean moving = true;
        boolean isOppositeTile = false;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                return false;
            }
            int curTile = board[curLocation.getRow()][curLocation.getCol()];
            if (curTile == this.color * -1) {
                isOppositeTile = true;
            } else if (curTile == this.color) {
                break;
            } else {
                return false;
            }
        }
        return isOppositeTile;  
    }
    
    private void flipTilesAI(int[][] board, Coordinate direction, Coordinate curLocation) {
        boolean moving = true;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                break;
            }
            int curRow = curLocation.getRow();
            int curCol = curLocation.getCol();
            if (board[curRow][curCol] == this.color) {
                break;
            }
            board[curRow][curCol] = this.color;
        }
    }
    
    private void flipOpposingTilesAI(int[][] board, Coordinate moveMade) {
        for (Coordinate direction : Constants.DIRECTIONS) {
            Coordinate curLocation = new Coordinate(moveMade.getRow(), moveMade.getCol());
            if (this.checkDirectionAI(board, direction, curLocation)) {
                Coordinate tempMoveMade = new Coordinate(moveMade.getRow(), moveMade.getCol());
                this.flipTilesAI(board, direction, tempMoveMade);
            }
        }
    }
    
    private void makeMoveAI(int[][] board, Coordinate move) {
        board[move.getRow()][move.getCol()] = this.color;
        
        this.flipOpposingTilesAI(board, move);
    }
    
    private Coordinate getEasyMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //get random move
        int randomNum = (int) (Math.random() * legalMoves.size());
        Coordinate move = legalMoves.get(randomNum);
        return move;
    }
    
    private int evaluateMedium(int[][] board) {
        int selfPieces = 0;
        int opponentPieces = 0;
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                if (board[row][col] == this.color) {
                    selfPieces++;
                } else if (board[row][col] == this.color * -1) {
                    opponentPieces++;
                }
            }
        }
        return selfPieces - opponentPieces;
    }
    
    private Coordinate getMediumMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //move that gets the most pieces
        Coordinate move = legalMoves.get(0);
        int bestEval = Integer.MIN_VALUE;
        for (Coordinate legalMove :legalMoves) {
            int[][] tempBoard = cloneBoard(board);
            //make move on tempBoard and count for the most pieces
            this.makeMoveAI(tempBoard, move);
            int eval = this.evaluateMedium(tempBoard);
            if (eval > bestEval) {
                bestEval = eval;
                move = legalMove;
            }
        }
        
        return move;
    }
    
    private Coordinate getHardMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //looking for corner and stable pieces
        Coordinate move = legalMoves.get(0);
        
        return move;
    }
    
    private Coordinate getExtremeMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //hard ai, but it uses minimax to look multiple moves ahead
        Coordinate move = legalMoves.get(0);
        
        return move;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public void changeColor(int playerColor) {
        this.color = playerColor;
    }
    
    public String getDifficulty() {
        return this.difficulty;
    }
    
    public void changeDifficulty(String playerDifficulty) {
        this.difficulty = playerDifficulty;
    }
}
