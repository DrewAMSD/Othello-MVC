package mvc.othello;

import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author student
 */
public class Constants {
    //tiles on board
    public static final int EMPTY = 0;
    public static final int BLACK = 1;
    public static final int WHITE = -1;
    
    //board size
    public static final int BOARD_SIZE = 8;
    
    //ai constants
    public static final String AI_EASY = "Easy";
    public static final String AI_MEDIUM = "Medium";
    public static final String AI_HARD = "Hard";
    public static final String AI_EXTREME = "Extreme";
    
    //game states
    public static final int IN_PLAY = -2;
    public static final int WHITE_WINS = -3;
    public static final int BLACK_WINS = -4;
    public static final int DRAW = -5;
    
    //directions for stepping through the board ***Do not change the order of elements in the array
    public static final Coordinate[] DIRECTIONS = {new Coordinate(1, 0), 
                            new Coordinate(-1,0),
                            new Coordinate(0, 1),
                            new Coordinate(0, -1),
                            new Coordinate(1, 1),
                            new Coordinate(-1, -1),
                            new Coordinate(1, -1),
                            new Coordinate(-1, 1) };
    
    //image icons ***filepath needs to be updated on a device by device basis
    public static final ImageIcon EMPTY_ICON = new ImageIcon("/home/drewam/Desktop/Projects/Othello-MVC/src/mvc/othello/images/emptyIcon.png");
    public static final ImageIcon BLACK_ICON = new ImageIcon("/home/drewam/Desktop/Projects/Othello-MVC/src/mvc/othello/images/blackIcon.png");
    public static final ImageIcon WHITE_ICON = new ImageIcon("/home/drewam/Desktop/Projects/Othello-MVC/src/mvc/othello/images/whiteIcon.png");
    public static final ImageIcon LEGAL_MOVE_ICON = new ImageIcon("/home/drewam/Desktop/Projects/Othello-MVC/src/mvc/othello/images/legalMoveIcon.png");
}
