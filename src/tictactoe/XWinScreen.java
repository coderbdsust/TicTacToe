/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 * This is the x win screen for 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class XWinScreen extends JFrame {

    private Icon xBackground, buttonBackground;
    private JButton playAgain = new JButton();
    private int buttonWidth, buttonHeight;
    private GameSound sound = new GameSound();

    XWinScreen() {
        new CreateMenuBar(this,true);
        setLocationRelativeTo(null);
        loadScreenBackground();
        setLayout(null);
        setBounds(300, 200, 780, 468);
        setContentPane(new JLabel(xBackground));
        addButton();
    }

    private void addButton() {
        loadButtonBackground();
        setButtonDimension();
        ButtonHandler handler = new ButtonHandler();
        playAgain.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        playAgain.setIcon(buttonBackground);
        playAgain.addActionListener(handler);
        playAgain.setBounds(330, 280, 160, 40);
        add(playAgain);
    }

    private void setButtonDimension() {
        this.buttonWidth = 160;
        this.buttonHeight = 40;

    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == playAgain) {
                if(sound.isSoundON()) sound.soundForPlayAgain();
                exitScreen();
                showMenuScreen();
            }
        }
    }

    private void loadScreenBackground() {
        xBackground = new ImageIcon(getClass().getResource("gameImages/ScreenBackground/XWon.png"));
    }

    private void loadButtonBackground() {
        buttonBackground = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/PlayAgain.png"));
    }

    private void exitScreen() {
        GameTicTacToe.screen1.dispose();
        GameTicTacToe.screen2.dispose();
    }

    private void showMenuScreen() {
        GameTicTacToe.setDefault();
        GameTicTacToe.screen1 = new CreateMenuScreen();
        GameTicTacToe.screen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen1.setSize(780, 468);
        GameTicTacToe.screen1.setVisible(true);
        GameTicTacToe.screen1.setResizable(false);
    }
}
