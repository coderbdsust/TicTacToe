/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *This class used for showing for start screen
 * @author Biswajit
 */
public class CreateStartScreen extends JFrame {
    private WindowAdapter windowAdapter;
    public CreateStartScreen() {
        setClosingSystem(this);
        ShowDesign design = new ShowDesign();
        getContentPane().add(design);
        pack();
        setBounds(250, 200, 780, 468);
        setVisible(true);
        setResizable(false);
        waitingTime(3000);
    }
    
    /**
     * Method for close the frame
     * @param frame 
     */
    
    private void setClosingSystem(JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowAdapter = new WindowAdapter() {
            public void windowClosing(WindowEvent evt){
                setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            }
        };
    }
    
    
    /**
     * Method for making time gap
     * @param miliSecond 
     */
    public void waitingTime(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
