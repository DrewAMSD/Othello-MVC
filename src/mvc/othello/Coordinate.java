/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mvc.othello;

/**
 *
 * @author drewam
 */
public class Coordinate {
    private int row;
    private int col;
    
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
    public int getRow() {
        return this.row;
    }
    
    public int getCol() {
        return this.col;
    }
    
    public boolean equals(int row, int col) {
        return (this.row == row && this.col == col);
    }
    
    @Override
    public String toString() {
        return ""+row+","+col+"";
    }
}
