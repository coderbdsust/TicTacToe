/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

 
/**
 * this a just a point class for point
 * @author Biswajit
 */
public class Point {
    
    private int x;
    private int y;
    
    Point(){
       setValue(0,0);
    }
    
    Point(int x, int y){
        setValue(x,y);
    }
    
    
    public void setX(int x){
        this.x=x;
    }
    
    public void setY(int y){
        this.y=y;
    }
    
    public void setValue(int x,int y){
        setX(x);
        setY(y);
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public Point getPoint(){
        return new Point(x,y);
    }
    
}
