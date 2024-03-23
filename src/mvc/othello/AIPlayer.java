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
            default:
                break;
        }
        return null;
    }
    
    private Coordinate getEasyMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //get random move
        int randomNum = (int) (Math.random() * legalMoves.size());
        Coordinate move = legalMoves.get(randomNum);
        return move;
    }
    
    private Coordinate getMediumMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        //move that gets the most pieces
        Coordinate move = legalMoves.get(0);
        
        return move;
    }
    
    private Coordinate getHardMove(int[][] board, ArrayList<Coordinate> legalMoves) {
        Coordinate move = legalMoves.get(0);
        
        return move;
    }
    
    public int getColor() {
        return this.color;
    }
    
    public void changeColor(int playerColor) {
        this.color = playerColor;
    }
    
    public String getDiffuculty() {
        return this.difficulty;
    }
    
    public void changeDifficulty(String playerDifficulty) {
        this.difficulty = playerDifficulty;
    }
}
