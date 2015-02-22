/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.*;
/**
 * This class used for all kind of sound for this game
 * @author Biswajit
 */
public class GameSound {

    private Clip menuClip, buttonClip;

    GameSound() {
    }
    
    /**
     * checking the game sound status
     * @return 
     */
    public boolean isSoundON(){
        return GameTicTacToe.soundStatus;
        
    }
    
    /**
     * setting game sound status
     * @param status 
     */
    
    public void setSoundStatus(boolean status){
        GameTicTacToe.soundStatus=status;
        new RecordedInfo().writeSoundFile(status);
        System.out.println("Sound Status:" + GameTicTacToe.soundStatus);
    }
    
    /**
     * method for creating sound for menu screen 
     */

    public void soundForMenuScreen() {
        String soundFilePath = "Music/theme3.wav";
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            menuClip = AudioSystem.getClip();
            menuClip.open(audio);
            menuClip.start();
            menuClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }

    
    /**
     * Method used for menu button sound
     */
    public void soundForMenuButton() {
        String soundFilePath = "Music/beep2.wav";

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            buttonClip = AudioSystem.getClip();
            buttonClip.open(audio);
            buttonClip.start();
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }
    
    /**
     * method used for x player move
     */

    public void soundXPlayerMove() {
    
        String soundFilePath = "Music/beep1.wav";

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            buttonClip = AudioSystem.getClip();
            buttonClip.open(audio);
            buttonClip.start();
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }

    /**
     * sound for o player move
     */
    public void soundOPlayerMove() {
       
        String soundFilePath = "Music/beep4.wav";

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            buttonClip = AudioSystem.getClip();
            buttonClip.open(audio);
            buttonClip.start();
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }
    
    /**
     * sound for play again button
     */

    public void soundForPlayAgain() {
        String soundFilePath = "Music/beep2.wav";

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            buttonClip = AudioSystem.getClip();
            buttonClip.open(audio);
            buttonClip.start();
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }

    /**
     * sound for game result
     */
    public void soundForGameResult() {
        String soundFilePath = "Music/result.wav";

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(GameSound.class.getResource(soundFilePath));
            buttonClip = AudioSystem.getClip();
            buttonClip.open(audio);
            buttonClip.start();
        } catch (Exception error) {
            System.out.println("Check The Path:" + soundFilePath);
            error.printStackTrace();
        }
    }
    /**
     * Stoping menu sound
     */
    public void stopMenuSound(){
        menuClip.stop();
    }
    /**
     * Stoping for button sound 
     */
    public void stopButtonSound(){
        buttonClip.stop();
    }
}
