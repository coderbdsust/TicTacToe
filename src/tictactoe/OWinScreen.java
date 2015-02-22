/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author Biswajit
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Method for showing game result of O player
 * @author Biswajit
 */

public class OWinScreen extends JFrame {

    private Icon oBackground, buttonBackground;
    private JButton playAgain;
    private int buttonWidth, buttonHeight;
    private GameSound sound = new GameSound();

    OWinScreen() {
        new CreateMenuBar(this,true);
        setLocationRelativeTo(null);
        loadScreenBackground();
        setLayout(null);
        setBounds(300, 200, 780, 468);
        setContentPane(new JLabel(oBackground));
        addButton();
    }
    
    /**
     * adding image and button to frame
     */

    private void addButton() {
        loadButtonBackground();
        setButtonDimension();
        ButtonHandler handler = new ButtonHandler();
        playAgain = new JButton();
        playAgain.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        playAgain.setIcon(buttonBackground);
        playAgain.addActionListener(handler);
        playAgain.setBounds(330, 280, 160, 40);
        add(playAgain);
    }
    
    /**
     * setting button dimension 
     */

    private void setButtonDimension() {
        this.buttonWidth = 160;
        this.buttonHeight = 40;
    }
    
    /**
     * for loading screen background for the frame
     */
    private void loadScreenBackground() {
        oBackground = new ImageIcon(getClass().getResource("gameImages/ScreenBackground/OWon.png"));
    }
    
    /**
     * for loading button background
     */

    private void loadButtonBackground() {
        buttonBackground = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/PlayAgain.png"));
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
