/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class CreateMenuScreen extends JFrame {

    final private int numberOfMenuButton = 4;
    private int buttonWidth, buttonHeight, gridWidth, gridHeight, buttonX, buttonY;
    private int XvsX;
    private Icon menuBackground;
    private Icon[] buttonBackground;
    private JButton[] menuButton;
    private GameSound sound = new GameSound();
    private JRadioButton soundButton, onePlayerButton, twoPlayerButton;
    private ButtonGroup group=new ButtonGroup();

    CreateMenuScreen() {
        setLocationRelativeTo(null);
        if (sound.isSoundON()) {
            sound.soundForMenuScreen();
        }
        new CreateMenuBar(this,false);
        setBounds(300, 200, 780, 468);
        setNumberOfMenuButtonAndBackground();
        loadMenuScreenBackground();
        setContentPane(new JLabel(menuBackground));
        setLayout(null);
        setMenuButtonSize();
        loadMenuButtonBackground();
        addMenuButton();
    }
    
    /**
     * Setting  dimension  of menu screen and game board
     */
    
 
 
    private void setScreenDimensionForGameBoard() {
        if (XvsX == 4) {
            this.gridWidth = 240;
            this.gridHeight = 280;
        } else if (XvsX == 5 || XvsX == 6) {
            this.gridWidth = 470;
            this.gridHeight = 510;
        } else {
            this.gridWidth = 268;
            this.gridHeight = 310;
        }
    }
    
    /**
     * initialization of menu screen button
     */
    private void setNumberOfMenuButtonAndBackground() {
        menuButton = new JButton[numberOfMenuButton];
        buttonBackground = new Icon[numberOfMenuButton];
    }
    
    /**
     * set menu button size
     */
    private void setMenuButtonSize() {
        buttonWidth = 220;
        buttonHeight = 33;
    }
    
    /**
     * initialization the menu button background
     */

    private void loadMenuButtonBackground() {
        buttonBackground[0] = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/w3.png"));
        buttonBackground[1] = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/w4.png"));
        buttonBackground[2] = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/w5.png"));
        buttonBackground[3] = new ImageIcon(getClass().getResource("gameImages/ButtonBackground/w6.png"));
    }
    
    /**
     * Set the game chosen
     * @param XvsX 
     */
    private void setXvsX(int XvsX) {
        this.XvsX = XvsX;
    }
    
    /**
     * Get the chosen game
     * @return 
     */
    private int getTheXvsX() {
        return XvsX;
    }
    
    /**
     * adding the menu button to the frame
     */

    private void addMenuButton() {
        MenuButtonHandler buttonHandler = new MenuButtonHandler();
        ToggleButtonHandler itemHandler = new ToggleButtonHandler();

        for (int indx = 0; indx < numberOfMenuButton; indx++) {
            setButtonPosition(indx);
            menuButton[indx] = new JButton();
            menuButton[indx].setIcon(buttonBackground[indx]);
            menuButton[indx].setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
            menuButton[indx].addActionListener(buttonHandler);
            add(menuButton[indx]);
        }

        soundButton = new JRadioButton("     Game Sound", sound.isSoundON());
        soundButton.addItemListener(itemHandler);
        soundButton.setBounds(160, 250, 130, 20);
        add(soundButton);

        onePlayerButton = new JRadioButton("Computer vs Human", false);
        twoPlayerButton = new JRadioButton("Human vs Human", true);
        onePlayerButton.addItemListener(itemHandler);
        twoPlayerButton.addItemListener(itemHandler);
        onePlayerButton.setBounds(315, 250, 150, 20);
        twoPlayerButton.setBounds(490, 250, 130, 20);
//        onePlayerButton.setEnabled(false);
        group.add(onePlayerButton);
        group.add(twoPlayerButton);
        add(onePlayerButton);
        add(twoPlayerButton);
    }
    
    /**
     * Set the button position
     * @param indx 
     */

    private void setButtonPosition(int indx) {

        if (indx == 0) {
            this.buttonX = 160;
            this.buttonY = 140;
        } else if (indx == 1) {
            this.buttonX = 400;
            this.buttonY = 140;

        } else if (indx == 2) {
            this.buttonX = 160;
            this.buttonY = 190;
        } else {
            this.buttonX = 400;
            this.buttonY = 190;
        }
    }
    
    /**
     * Set all menu button handler
     */

    private class MenuButtonHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            for (int indx = 0; indx < numberOfMenuButton; indx++) {
                if (event.getSource() == menuButton[indx]) {

                    if (sound.isSoundON()) {
                        sound.soundForMenuButton();
                    }

                    setXvsX(indx + 3);
                    showChosenGame();
                    setScreenDimensionForGameBoard();
                    exitScreen();
                    showBoardScreen();
                }
            }
        }
    }
    
    /**
     * Class used for toggle menu button handler
     */

    private class ToggleButtonHandler implements ItemListener {

        public void itemStateChanged(ItemEvent event) {
            if (event.getItem() == soundButton) {
                if (sound.isSoundON()) {
                    sound.stopMenuSound();
                    sound.setSoundStatus(false);
                } else {
                    sound.soundForMenuScreen();
                    sound.setSoundStatus(true);
                }
            }
            
            if(event.getItem()==onePlayerButton){
                GameTicTacToe.onePlayerMatch=true;
                GameTicTacToe.twoPlayerMatch=false;
            }
            
            if(event.getItem()==twoPlayerButton){
                GameTicTacToe.twoPlayerMatch=true;
                GameTicTacToe.onePlayerMatch=false;
            }

        }
    }
    
    /**
     * for viewing which game is selected 
     */

    private void showChosenGame() {
        System.out.println("ChosenGame: " + XvsX + " In A Row");

    }
    
    /**
     * Exiting main frame
     */

    private void exitScreen() {
        GameTicTacToe.screen1.dispose();
        if(sound.isSoundON()) sound.stopMenuSound();
    }
    
    /**
     *Showing the game screen
     */
    private void showBoardScreen() {
        GameTicTacToe.screen1 = new CreateBoardScreen(XvsX);
        GameTicTacToe.screen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen1.setSize(gridWidth, gridHeight);
        GameTicTacToe.screen1.setVisible(true);
        GameTicTacToe.screen1.setResizable(false);
        GameTicTacToe.screen1.getContentPane().setBackground(Color.gray);
    }
    
    /**
     * Method for  loading menu background
     */

    private void loadMenuScreenBackground() {
        menuBackground = new ImageIcon(getClass().getResource("gameImages/ScreenBackground/MenuBackground4.png"));
    }

}
