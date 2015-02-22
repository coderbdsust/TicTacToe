/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tictactoe;

import java.util.*;
import java.lang.*;
import java.io.*;

public class RecordedInfo {
    
    String fileURL;
    private Scanner scan;
    private Formatter file;
    private boolean soundStatus;
    private int highScore;
    
    RecordedInfo(){
    }
    
    private void openSoundFileForWrite(){
        fileURL = "src\\tictactoe\\Music\\SoundFile.txt";
        try{
            file = new Formatter(fileURL);
        }
        catch(Exception error){
            System.out.println("Check the file path");
            error.printStackTrace();
        }
    }
    
    private void openHighScoreFileForWrite(){
        fileURL = "src\\tictactoe\\HighScore\\HighScore.txt";
        try{
            file = new Formatter(fileURL);
        }
        catch(Exception error){
            System.out.println("Check the file path");
            error.printStackTrace();
        }
    }
    
    private void openSoundFileForRead(){
        fileURL = "src\\tictactoe\\Music\\SoundFile.txt";
        try{
            scan = new Scanner(new File(fileURL));
        }
        catch(Exception error){
            System.out.println("Check the file path");
            error.printStackTrace();
        }
    }
    
    private void openHighScoreFileForRead(){
        fileURL = "src\\tictactoe\\HighScore\\HighScore.txt";
        try{
            scan = new Scanner(new File(fileURL));
        }
        catch(Exception error){
            System.out.println("Check the file path");
            error.printStackTrace();
        }
    }
    
    public void writeSoundFile(boolean status){
        openSoundFileForWrite();
        if(status){
            file.format("true");
        }
        else file.format("false");
        closeWriteFile();
    }
    
    public void writeHighScoreFile(int score){
        openHighScoreFileForWrite();
        int previousScore = readHighScoreFile();
        if(score>previousScore){
            file.format("%d", score);
        }
        closeWriteFile();
    }
    
    public boolean readSoundFile(){
        openSoundFileForRead();
        soundStatus = scan.nextBoolean();
        closeReadFile();
        return soundStatus;
    }
    
    public int readHighScoreFile(){
        openHighScoreFileForRead();
        highScore = scan.nextInt();
        closeReadFile();
        return highScore;
    }
    
    private void closeReadFile(){
        scan.close();
    }
    
    private void closeWriteFile(){
        file.close();
    }
}
