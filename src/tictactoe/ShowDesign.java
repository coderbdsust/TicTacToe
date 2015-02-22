/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *  For showing the making the design
 * @author Biswajit
 */
public class ShowDesign extends JComponent{
    
    public Graphics graphics=null;
   
    @Override
    public void update(Graphics g){
        paint(g);
    }
    
    @Override
    public void paint(Graphics g){
        if(graphics==null){
            graphics = g.create();
        }
        
        ScreenDesign.drawStartPage(graphics);
        repaint(); 
        waitingTime(200);
    }
    
    public  void waitingTime(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException err) {
            err.getMessage();
        }
    }
    
}
