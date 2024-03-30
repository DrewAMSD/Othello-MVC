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
                return getExtremeMove(board);
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
    
    private boolean checkDirectionAI(int[][] board, Coordinate direction, Coordinate curLocation, int colorMakingMove) {
        boolean moving = true;
        boolean isOppositeTile = false;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                return false;
            }
            int curTile = board[curLocation.getRow()][curLocation.getCol()];
            if (curTile == colorMakingMove * -1) {
                isOppositeTile = true;
            } else if (curTile == colorMakingMove) {
                break;
            } else {
                return false;
            }
        }
        return isOppositeTile;  
    }
    
    private void flipTilesAI(int[][] board, Coordinate direction, Coordinate curLocation, int colorMakingMove) {
        boolean moving = true;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                break;
            }
            int curRow = curLocation.getRow();
            int curCol = curLocation.getCol();
            if (board[curRow][curCol] == colorMakingMove) {
                break;
            }
            board[curRow][curCol] = colorMakingMove;
        }
    }
    
    private void flipOpposingTilesAI(int[][] board, Coordinate moveMade, int colorMakingMove) {
        for (Coordinate direction : Constants.DIRECTIONS) {
            Coordinate curLocation = new Coordinate(moveMade.getRow(), moveMade.getCol());
            if (this.checkDirectionAI(board, direction, curLocation, colorMakingMove)) {
                Coordinate tempMoveMade = new Coordinate(moveMade.getRow(), moveMade.getCol());
                this.flipTilesAI(board, direction, tempMoveMade, colorMakingMove);
            }
        }
    }
    
    private void makeMoveAI(int[][] board, Coordinate move, int colorMakingMove) {
        board[move.getRow()][move.getCol()] = colorMakingMove;
        
        this.flipOpposingTilesAI(board, move, colorMakingMove);
    }
    
    private boolean isCorner(int row, int col) {
        return (row == 0 && col == 0
                || row == 0 && col == Constants.BOARD_SIZE-1
                || row == Constants.BOARD_SIZE-1 && col == 0
                || row == Constants.BOARD_SIZE-1 && col == Constants.BOARD_SIZE-1);
    }
    
    private Coordinate getEasyMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //get random move
        int randomNum = (int) (Math.random() * legalMoves.size());
        Coordinate move = legalMoves.get(randomNum);
        return move;
    }
    
    private int evaluateMedium(int[][] board) {
        //eval based on corners and taking the most pieces
        int eval = 0;
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                if (board[row][col] == this.color) {
                    eval++;
                    if (isCorner(row, col)) {
                        eval += 10;
                    }
                }
            }
        }
        return eval;
    }
    
    private Coordinate getMediumMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //move that gets the most pieces and corners
        Coordinate move = null;
        int bestEval = Integer.MIN_VALUE;
        for (Coordinate legalMove : legalMoves) {
            int[][] tempBoard = cloneBoard(board);
            this.makeMoveAI(tempBoard, legalMove, this.color);
            int eval = this.evaluateMedium(tempBoard);
            if (eval > bestEval) {
                bestEval = eval;
                move = legalMove;
            }
        }
        return move;
    }
    
    private boolean isDirectionFilled(int[][] board, Coordinate direction, Coordinate location) {
        Coordinate oppositeDirection = new Coordinate(direction.getRow()*-1, direction.getCol()*-1);
        Coordinate cloneLocation = new Coordinate(location.getRow(), location.getCol());
        while (location.isInsideBoard()) {
            if (board[location.getRow()][location.getCol()] == Constants.EMPTY) {
                return false;
            }
            location.add(direction);
        }
        while (cloneLocation.isInsideBoard()) {
            if (board[cloneLocation.getRow()][cloneLocation.getCol()] == Constants.EMPTY) {
                return false;
            }
            cloneLocation.add(oppositeDirection);
        }
        return true;
    }
    
    private boolean getStability(int[][] board, Coordinate direction, Coordinate location, int playerColor) {
        while (location.isInsideBoard()) {
            int curTile = board[location.getRow()][location.getCol()];
            if (curTile == playerColor) {
                location.add(direction);
                continue;
            }
            if (curTile == Constants.EMPTY) {
                return false;
            }
            return isDirectionFilled(board, direction, new Coordinate(location.getRow(), location.getCol()));
        }
        return true;
    }
    
    private boolean isStable(int[][] board, int row, int col, int playerColor) {
        for (int i = 0; i < Constants.DIRECTIONS.length; i+=2) {
            boolean stability1 = getStability(board, Constants.DIRECTIONS[i], new Coordinate(row, col), playerColor);
            boolean stability2 = getStability(board, Constants.DIRECTIONS[i+1], new Coordinate(row, col), playerColor);
            if (stability1 || stability2) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    private int edgesControlled(int[][] board, int playerColor) {
        int edgesControlled = 0;
        Coordinate east = Constants.DIRECTIONS[2];
        Coordinate south = Constants.DIRECTIONS[0];
        Coordinate loc;
        Coordinate direction;
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                loc = new Coordinate(0, 0);
                direction = (i == 0 ? east : south);
            } else if (i == 2) {
                loc = new Coordinate(Constants.BOARD_SIZE-1, 0);
                direction = east;
            } else {
                loc = new Coordinate(0, Constants.BOARD_SIZE-1);
                direction = south;
            }
            boolean ownsEdge = true;
            while (loc.isInsideBoard()) {
                int curTile = board[loc.getRow()][loc.getCol()];
                if (curTile == playerColor) {
                    loc.add(direction);
                    continue;
                }
                ownsEdge = false;
                break;
            }
            if (ownsEdge) {
                edgesControlled++;
            }
        }
        return edgesControlled;
    }
    
    private int evaluate(int[][] board, int playerColor) {
        //check for corner pieces and for stable pieces(pieces that can't be taken)
        int eval = 0;
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                int tile = board[row][col];
                if (tile != Constants.EMPTY) {
                    if (this.isCorner(row, col)) {
                        eval += (tile == playerColor ? 100 : -100);
                    } else if (this.isStable(board, row, col, playerColor)) {
                        eval += (tile == playerColor ? 100 : -100);
                    } else if (this.difficulty.equals(Constants.AI_HARD)) {
                        //since hard doesn't minimax, it'll take the move with the highest pieces if it doesn't find corner or stable pieces
                        eval += (tile == playerColor ? 1 : -1);
                    }
                }
            }
        }
        /*//test eval for playing more for edges
        eval += (edgesControlled(board, playerColor) * 10);
        eval -= (edgesControlled(board, playerColor*-1) * 10); */
        return eval;
    }
    
    private Coordinate getHardMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //looking for corner and stable pieces
        Coordinate move = null;
        int bestEval = Integer.MIN_VALUE;
        for (Coordinate legalMove : legalMoves) {
            int[][] tempBoard = this.cloneBoard(board);
            this.makeMoveAI(tempBoard, legalMove, this.color);
            int eval = this.evaluate(tempBoard, this.color); //difference between medium and hard
            if (eval > bestEval) {
                bestEval = eval;
                move = legalMove;
            }
        }
        return move;
    }
    
    private boolean checkDirection(int[][] board, Coordinate direction, Coordinate curLocation, int color) {
        boolean moving = true;
        boolean isOppositeTile = false;
        while (moving) {
            curLocation.add(direction);
            if (!curLocation.isInsideBoard()) {
                return false;
            }
            int curTile = board[curLocation.getRow()][curLocation.getCol()];
            if (curTile == color * -1) {
                isOppositeTile = true;
            } else if (curTile == color) {
                break;
            } else {
                return false;
            }
        }
        return isOppositeTile;  
    }
    
    private boolean isLegalMove(int[][] board, Coordinate possibleMove, int color) {
        for (Coordinate direction : Constants.DIRECTIONS) {
            Coordinate tempMove = new Coordinate(possibleMove.getRow(), possibleMove.getCol());
            if (this.checkDirection(board, direction, tempMove, color)) {
                return true;
            }
        }
        return false;
    }
    
    private ArrayList<Coordinate> getLegalMoves(int[][] board, int color) {
        ArrayList<Coordinate> newLegalMoves = new ArrayList<>();
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE; col++) {
                Coordinate possibleMove = new Coordinate(row, col);
                if (board[possibleMove.getRow()][possibleMove.getCol()] == Constants.EMPTY && isLegalMove(board, possibleMove, color)) {
                    newLegalMoves.add(possibleMove);
                }
            }
        }
        return newLegalMoves;
    }
    
    private Coordinate getExtremeMove(int[][] board) {
        //hard ai, but it uses minimax to look multiple moves ahead
        MiniMax miniMax = new MiniMax(board, this.color, 0, true);
        return miniMax.getMove();
    }
    
    public class MiniMax {
        private final static int MAX_DEPTH = 6;
        private Coordinate move;
        private int eval;

        public MiniMax(int[][] board, int color, int depth, boolean isMaxingPlayer) {
            if (depth == MAX_DEPTH) {
                this.eval = evaluate(board, color);
            } else {
                int colorMakingMove = (isMaxingPlayer ? color : color *-1);
                ArrayList<Coordinate> legalMoves = getLegalMoves(board, colorMakingMove);
                if (legalMoves.isEmpty()) {
                    this.eval = evaluate(board, color);
                } else {
                    this.eval = isMaxingPlayer ? Integer.MIN_VALUE : Integer.MAX_VALUE; 
                    for (Coordinate legalMove : legalMoves) {
                        //int[][] tempBoard = cloneBoard(board);
                        int[][] tempBoard = new int[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
                        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
                            for (int j = 0; j < Constants.BOARD_SIZE; j++) {
                                tempBoard[i][j] = board[i][j];
                            }
                        }
                        makeMoveAI(tempBoard, legalMove, colorMakingMove);
                        MiniMax child = new MiniMax(tempBoard, color, depth+1, !isMaxingPlayer);
                        int newEval = child.getEval();
                        if (isMaxingPlayer) {
                            if (newEval > this.eval) { 
                                this.eval = newEval;
                                if (depth == 0) {
                                    this.move = legalMove;
                                }
                            }
                        } else {
                            if (newEval < this.eval) { 
                                this.eval = newEval;
                            }
                        }
                    }
                }
            }
        }
        
        public Coordinate getMove() {
            return this.move;
        }
        
        public int getEval() {
            return this.eval;
        }
    }
    
    //methods for model to change ai
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
