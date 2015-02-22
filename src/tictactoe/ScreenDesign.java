/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.management.Query;

/**
 * This class used for stating screen design
 * @author Biswajit
 */
class ScreenDesign {

    private static boolean notSwitch = true;
    private static int colorSwitch = 1;
    private static int whichLine = 1;
    private static final int moveX=20;
    private static int startX = 225;

    public static void drawStartPage(Graphics graphics) {
        //For shoring startscreeen background
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 780, 468);
        //For showing TicTacToe
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Gabriola", Font.BOLD, 80));
        graphics.drawString("TicTacToe", 225, 220);
        
        graphics.setColor(Color.WHITE);
        graphics.fillRect(225, 320, 300, 10);
        
        graphics.setColor(Color.BLACK);
        startX+=moveX;
        graphics.fillRect(startX, 320, 20, 10);
    }

 

    public static void waitingTime(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
