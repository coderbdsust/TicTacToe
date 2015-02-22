/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import javax.swing.*;

/**
 * This class is the controller of game 
 * @author Biswajit
 */

public class GameTicTacToe {

    public static int menuWidth, menuHeight;
    public static JFrame screen1, screen2;
    public static boolean soundStatus, onePlayerMatch, twoPlayerMatch,infoOpen=false;
    public static boolean gameFinish=false;

    GameTicTacToe() {
        
        showStartScreen();
        exitScreen();
        setDefault();
        setMenuDimension();
        showMenuScreen();
    }
    
    
    /**
     * used to checking game status
     * @return 
     */
    public static boolean isGameFinish(){
        return gameFinish;
    }
    
    /**
     * set default value of sound and player and game status
     */

    public static void setDefault() {
        gameFinish=false;
        soundStatus = new RecordedInfo().readSoundFile();
        onePlayerMatch = false;
        twoPlayerMatch = true;
    }
    
    /**
     * set menu dimension
     */

    private void setMenuDimension() {
        menuWidth = 780;
        menuHeight = 468;
    }

    
    /**
     * showing start screen
     */
    public void showStartScreen() {
//        screen1.removeAll();
        screen1 = new CreateStartScreen();
        screen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen1.setSize(menuWidth, menuHeight);
        screen1.setVisible(true);
        screen1.setResizable(false);
    }
    
    /**
     * for closing the main frame
     */

    public void exitScreen() {
        screen1.setVisible(false);
        screen1.dispose();
    }
    
   
    /**
     * for showing menu screen
     */
    public void showMenuScreen() {
        screen1 = new CreateMenuScreen();
        screen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen1.setSize(menuWidth, menuHeight);
        screen1.setVisible(true);
        screen1.setResizable(false);
    }
}
