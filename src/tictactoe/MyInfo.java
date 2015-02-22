/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * the frame class used for showing developer information
 * @author Biswajit
 */
public class MyInfo extends JFrame{
   
    private Icon background;
    private WindowListener exitListener;
    
    MyInfo(){
      
        loadBackground();
        setContentPane(new JLabel(background));
        setLayout(null);
        setSize(500,270);
        setVisible(true);
        setResizable(false);
        
        exitListener = new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent event){
                    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                    GameTicTacToe.infoOpen=false;
                }
            };
        addWindowListener(exitListener);
    }
    
    
    
    private void loadBackground(){
        background = new ImageIcon(getClass().getResource("gameImages/ScreenBackground/myInfo.png"));
    }
}
