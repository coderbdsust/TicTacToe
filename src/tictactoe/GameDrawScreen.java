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
 * This frame class used for showing the game draw screen
 * @author Biswajit
 */
public class GameDrawScreen extends JFrame {

    private Icon drawBackground, buttonBackground;
    private JButton playAgain;
    private int buttonWidth, buttonHeight;
    private GameSound sound = new GameSound();

    GameDrawScreen() {
        new CreateMenuBar(this, true);
        setBounds(300, 200, 780, 468);
        loadScreenBackground();
        setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(new JLabel(drawBackground));
        addButton();
    }
    
    /**
     * add the button and background the frame
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
     * setting button dimension for frame
     */
    private void setButtonDimension() {
        this.buttonWidth = 160;
        this.buttonHeight = 40;
    }
    
    /**
     * loading the frame background
     */

    private void loadScreenBackground() {
        drawBackground = new ImageIcon(getClass().getResource("gameImages/ScreenBackground/Draw.png"));
    }
    
    /**
     * background of button
     */

    private void loadButtonBackground() {
        buttonBackground = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/PlayAgain.png"));
    }

    private class ButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == playAgain) {
                if (sound.isSoundON()) {
                    sound.soundForPlayAgain();
                }
                exitScreen();
                showMenuScreen();
            }
        }
    }
    
    
    /**
     * Exiting the frame
     */
    private void exitScreen() {
//        System.out.println("exitScreen");
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
