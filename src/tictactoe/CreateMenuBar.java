/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * This method used to make game menu bar
 * @author Biswajit
 */

public class CreateMenuBar {

    private JMenuBar gameMenuBar;
    private JMenu gameTicTacToe, gameInfo;
    private JMenuItem exitGame,  restart, aboutGame;
    private JRadioButtonMenuItem gameSound;
    private GameSound sound = new GameSound();
    private JFrame screen;

    public CreateMenuBar(JFrame frame, boolean enableSoundButton) {

        gameMenuBar = new JMenuBar();
        gameTicTacToe = new JMenu("TicTacToe");
       
        gameInfo = new JMenu("Help");
        gameSound = new JRadioButtonMenuItem("Game Sound", new RecordedInfo().readSoundFile());
        gameSound.setEnabled(enableSoundButton); 
    
        
      
        exitGame = new JMenuItem("Exit Game");
        aboutGame = new JMenuItem("About Game");
        restart  = new JMenuItem("Restart");

        gameSound.addItemListener(
                new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent event) {
                        if (event.getItem() == gameSound) {
                            if (sound.isSoundON()) {
                                sound.setSoundStatus(false);
                            } else {
                                sound.setSoundStatus(true);
                            }
                        }

                    }
                }
        );

        aboutGame.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent event) {
                        if (event.getSource() == aboutGame && GameTicTacToe.infoOpen==false) {
                            new MyInfo();
                            GameTicTacToe.infoOpen=true;
                        }
                    }
                });

        exitGame.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent event){
                        if (event.getSource() == exitGame) {
                           System.exit(0);
                            
                        }
                    }

                }
        );
        
        restart.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                if(GameTicTacToe.isGameFinish()){
                    exitGameResultScreen();
                }
                showMenuScreen();
            }
        }
        );
        

        
        gameTicTacToe.add(gameSound);
        gameTicTacToe.add(restart);
        gameTicTacToe.add(exitGame);
        gameInfo.add(aboutGame);
        
        gameMenuBar.add(gameTicTacToe);
        gameMenuBar.add(gameInfo);
        frame.setJMenuBar(gameMenuBar);
    }
    
    
    /**
     * method used for exiting the game result screen
     */
    public void exitGameResultScreen(){
        GameTicTacToe.screen2.setVisible(false);
        GameTicTacToe.screen2.dispose();
    }
    
    /**
     * method used for exiting the main frame
     */
    public void exitScreen() {
        GameTicTacToe.screen1.setVisible(false);
        GameTicTacToe.screen1.dispose();
    }
    
    /**
     * method used for showing menu screen
     */
    
    public void showMenuScreen() {
        exitScreen();
        GameTicTacToe.setDefault();
        GameTicTacToe.screen1 = new CreateMenuScreen();
        GameTicTacToe.screen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen1.setSize(780, 468);
        GameTicTacToe.screen1.setVisible(true);
        GameTicTacToe.screen1.setResizable(false);
    }
   
}
