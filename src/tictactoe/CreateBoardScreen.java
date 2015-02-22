/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class used for logical operation of the game.
 *
 * @author Biswajit
 */
public class CreateBoardScreen extends JFrame {

    private JButton[][] button;
    private int[][] gameBoard;
    private int numberOfButton;
    private int xMove, oMove, IOX, IOY;
    private int buttonWidth, buttonHeight;
    private Icon XImage, OImage, winXImage, winOImage;
    private int whichMove, countMove;
    private int XvsX;
    private final ArrayList winPath = new ArrayList();
    private boolean gameStatus;
    private final GameSound sound = new GameSound();
    private final ArrayList<Point> randomMove = new ArrayList<>();

    CreateBoardScreen(int XvsX) {
        super("Tic Tac Toe!");
        CreateMenuBar createMenuBar = new CreateMenuBar(this, true);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefault();
        setBounds(300, 200, 780, 468);
        HowManyPlayer();
        setGameXvsX(XvsX);
        setNumberOfButtonAndButtonSize();
        setNumberOfButtonAndGameBoard();
        setGameFinishStatus(false);
        loadImages();
        addButton();
        setRandomMove();

    }

    /**
     * This method is used for viewing which type game is playing
     */
    private void HowManyPlayer() {
        if (GameTicTacToe.onePlayerMatch) {
            System.out.println("Game: One Player");
        }

        if (GameTicTacToe.twoPlayerMatch) {
            System.out.println("Game: Two Players");
        }
    }

    /**
     * This method is used for random move for one player game.
     */
    private void setRandomMove() {
        randomMove.add(new Point(1, 1));
        randomMove.add(new Point(-1, -1));
        randomMove.add(new Point(-1, 1));
        randomMove.add(new Point(1, -1));
        randomMove.add(new Point(-1, 0));
        randomMove.add(new Point(1, 0));
        randomMove.add(new Point(0, -1));
        randomMove.add(new Point(0, 1));
    }

    /**
     * Set the flag value of player and how many move already taken
     */
    private void setDefault() {
        this.xMove = 1;
        this.oMove = 2;
        this.countMove = 0;
        this.whichMove = xMove;
    }

    /**
     * This method is used for set game finish or not
     * @param gameStatus 
     */
    private void setGameFinishStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
        GameTicTacToe.gameFinish = gameStatus;
    }
    /**
     * Used for get game status
     * @return 
     */
    private boolean isGameFinish() {
        return gameStatus;
    }

    /**
     * For which game 3x3 , 4x4 ...
     * @param XvsX 
     */
    private void setGameXvsX(int XvsX) {
        this.XvsX = XvsX;
    }

    
    /**
     * initialize the game board button and flag board
     */
    private void setNumberOfButtonAndGameBoard() {
        button = new JButton[numberOfButton][numberOfButton];
        gameBoard = new int[numberOfButton][numberOfButton];
    }

    /**
     * Set the number of button and button size of the game board
     */
    private void setNumberOfButtonAndButtonSize() {
        if (XvsX == 4) {
            this.buttonWidth = this.buttonHeight = 40;
            this.numberOfButton = 5;
        } else if (XvsX == 5 || XvsX == 6) {
            this.buttonWidth = this.buttonHeight = 25;
            this.numberOfButton = 15;
        } else {
            this.buttonWidth = this.buttonHeight = 80;
            this.numberOfButton = 3;
        }
    }
    
    /**
     * load all the image used in board screen
     */
    private void loadImages() {
        if (XvsX == 3) {
            XImage = new ImageIcon(getClass().getResource("gameImages/O_X/X80_1.png"));
            OImage = new ImageIcon(getClass().getResource("gameImages/O_X/O80_1.png"));
            winXImage = new ImageIcon(getClass().getResource("gameImages/O_X/X80_W.png"));
            winOImage = new ImageIcon(getClass().getResource("gameImages/O_X/O80_W.png"));
        } else if (XvsX == 4) {
            XImage = new ImageIcon(getClass().getResource("gameImages/O_X/X40_BR.png"));
            OImage = new ImageIcon(getClass().getResource("gameImages/O_X/O40_BR.png"));
            winXImage = new ImageIcon(getClass().getResource("gameImages/O_X/X40_W.png"));
            winOImage = new ImageIcon(getClass().getResource("gameImages/O_X/O40_W.png"));
        } else if (XvsX == 5) {
            XImage = new ImageIcon(getClass().getResource("gameImages/O_X/X25_1.png"));
            OImage = new ImageIcon(getClass().getResource("gameImages/O_X/O25_1.png"));
            winXImage = new ImageIcon(getClass().getResource("gameImages/O_X/X25_W.png"));
            winOImage = new ImageIcon(getClass().getResource("gameImages/O_X/O25_W.png"));
        } else {
            XImage = new ImageIcon(getClass().getResource("gameImages/O_X/X25_1.png"));
            OImage = new ImageIcon(getClass().getResource("gameImages/O_X/O25_1.png"));
            winXImage = new ImageIcon(getClass().getResource("gameImages/O_X/X25_W.png"));
            winOImage = new ImageIcon(getClass().getResource("gameImages/O_X/O25_W.png"));
        }
    }
    
    /**
     * adding all the button to frame
     */
    private void addButton() {
        GameButtonHandler handler = new GameButtonHandler();
        for (int IDX = 0; IDX < numberOfButton; IDX++) {
            for (int IDY = 0; IDY < numberOfButton; IDY++) {
                button[IDX][IDY] = new JButton();
                button[IDX][IDY].setBackground(Color.BLACK);
                button[IDX][IDY].setPreferredSize(new Dimension(buttonWidth, buttonHeight));
                button[IDX][IDY].addActionListener(handler);
                add(button[IDX][IDY]);
            }
        }
    }
    
    /**
     * Set a X image in a button
     * @param idx
     * @param idy 
     */

    private void setXImageAndXValue(int idx, int idy) {
        this.button[idx][idy].setIcon(this.XImage);
        this.gameBoard[idx][idy] = xMove;
        this.whichMove = oMove;

    }
    /**
     * Set a O image in a button
     * @param idx
     * @param idy 
     */

    private void setOImageAndOValue(int idx, int idy) {
        this.button[idx][idy].setIcon(this.OImage);
        this.gameBoard[idx][idy] = oMove;
        this.whichMove = xMove;

    }
    
    /**
     * Set winner X image in line
     */

    private void setWinnerXImage() {
        Integer ix, iy;
        for (int indx = 0; indx < winPath.size(); indx += 2) {
            ix = (Integer) winPath.get(indx);
            iy = (Integer) winPath.get(indx + 1);
            button[ix][iy].setIcon(winXImage);
        }
        winPath.clear();
    }
    
    /**
     * Set winner O image in line
     */

    private void setWinnerOImage() {
        Integer ix, iy;
        for (int indx = 0; indx < winPath.size(); indx += 2) {
            ix = (Integer) winPath.get(indx);
            iy = (Integer) winPath.get(indx + 1);
            button[ix][iy].setIcon(winOImage);
        }
        winPath.clear();

    }
    
    /***
     * Set action handler for all game board button
     */

    private class GameButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {

            if (isGameFinish()) {
                System.out.println("GameFinish: " + isGameFinish());
                return;
            }

            LoopX:
            for (int IDX = 0; IDX < numberOfButton; IDX++) {
                LoopY:
                for (int IDY = 0; IDY < numberOfButton; IDY++) {

                    if (event.getSource() == button[IDX][IDY]) {
                        if (gameBoard[IDX][IDY] != 0) {
                            break LoopX;
                        }

                        if (GameTicTacToe.twoPlayerMatch) {
                            twoPlayerMove(IDX, IDY);
                        }

                        if (GameTicTacToe.onePlayerMatch) {
                            onePlayerMove(IDX, IDY);
                        }

                        break LoopX;
                    }
                }
            }

            if (GameTicTacToe.twoPlayerMatch) {
                if (!isGameFinish() && isFinishNumberOfMove()) {
                    if (sound.isSoundON()) {
                        sound.soundForGameResult();
                    }
                    setGameFinishStatus(true);
                    showGameDrawScreen();
                }
            }
        }
    }

    /**
     * Handling two player move operation
     * @param IDX
     * @param IDY 
     */
    private void twoPlayerMove(int IDX, int IDY) {
        countMove++;
        if (whichMove == xMove) {
            if (sound.isSoundON()) {
                sound.soundXPlayerMove();
            }

            setXImageAndXValue(IDX, IDY);
            System.out.println("Position: ( " + IDX + " " + IDY + " ) GameBoardX: " + gameBoard[IDX][IDY] + " Game Finish: " + isGameFinish());
            if (gameResultFound(IDX, IDY)) {
                if (sound.isSoundON()) {
                    sound.soundForGameResult();
                }
                setGameFinishStatus(true);
                setWinnerXImage();
                showXWinScreen();
                System.out.println("Player X Winner");
            }
        } else {
            if (sound.isSoundON()) {
                sound.soundOPlayerMove();
            }

            setOImageAndOValue(IDX, IDY);

            if (gameResultFound(IDX, IDY)) {
                if (sound.isSoundON()) {
                    sound.soundForGameResult();
                }
                setGameFinishStatus(true);
                setWinnerOImage();
                showOWinScreen();
                System.out.println("Player O Winner");
            }
            System.out.println("Position: ( " + IDX + " " + IDY + " ) GameBoardO: " + gameBoard[IDX][IDY] + " Game Finish: " + isGameFinish());
        }
    }
    
    /**
     * Handling one player move operation
     * @param IDX
     * @param IDY 
     */

    private void onePlayerMove(int IDX, int IDY) {
        countMove++;

        setXImageAndXValue(IDX, IDY);

        if (gameResultFound(IDX, IDY)) {
            if (sound.isSoundON()) {
                sound.soundForGameResult();
            }
            setGameFinishStatus(true);
            setWinnerXImage();
            showXWinScreen();
            System.out.println("Player X Winner");
        }

        System.out.println("My Position: (" + IDX + " " + IDY + ") GameBoardX: " + gameBoard[IDX][IDY] + " Game Finish: " + isGameFinish());

        if (isGameFinish()) {
            return;
        }

        if (isFinishNumberOfMove()) {
            if (sound.isSoundON()) {
                sound.soundForGameResult();
            }
            setGameFinishStatus(true);
            showGameDrawScreen();
            return;
        }

        findPosition(IDX, IDY);

        countMove++;

        if (sound.isSoundON()) {
            sound.soundOPlayerMove();
        }

        setOImageAndOValue(IOX, IOY);
        if (gameResultFound(IOX, IOY)) {
            if (sound.isSoundON()) {
                sound.soundForGameResult();
            }
            setGameFinishStatus(true);
            setWinnerOImage();
            showOWinScreen();
            System.out.println("Player O Winner");
        }

        System.out.println("PC Position: (" + IOX + " " + IOY + ") GameBoardO: " + gameBoard[IOX][IOY] + " Game Finish: " + isGameFinish());

        if (isGameFinish()) {
            return;
        }

        if (isFinishNumberOfMove()) {
            if (sound.isSoundON()) {
                sound.soundForGameResult();
            }
            setGameFinishStatus(true);
            showGameDrawScreen();

        }
    }
    
    /**
     * Find a move for computer
     * @param x
     * @param y 
     */

    private void findPosition(int x, int y) {

        checkPossibleMove();
//        showBoard();

        if (IOX != -1 && IOY != -1) {
            return;
        }
//        System.out.println(IOX + " " + IOY);

        Collections.shuffle(randomMove);
        int newX, newY;

        LayerLoop:

        for (int layer = 1; layer < 16; layer++) {
            for (int i = 0; i < randomMove.size(); i++) {
                Point p = randomMove.get(i);
                newX = x + p.getX() * layer;
                newY = y + p.getY() * layer;

                if (newX >= 0 && newX < numberOfButton && newY >= 0 && newY < numberOfButton && gameBoard[newX][newY] == 0) {
                    IOX = newX;
                    IOY = newY;
                    break LayerLoop;
                }
            }
        }

    }
    
    /**
     * Help the previous method for move finding 
     */

    private void checkPossibleMove() {
        int xi = -1, yi = -1;

        if (XvsX == 3 && gameBoard[1][1] == 0) {
            IOX = 1;
            IOY = 1;
            return;
        }

        //find 2 X in one row
        for (int idx = 0; idx < numberOfButton; idx++) {
            for (int idy = 0; idy < numberOfButton - 2; idy++) {

                if (gameBoard[idx][idy] == xMove && gameBoard[idx][idy + 1] == xMove && gameBoard[idx][idy + 2] == 0) {
                    xi = idx;
                    yi = idy + 2;
                }

                if (gameBoard[idx][idy] == 0 && gameBoard[idx][idy + 1] == xMove && gameBoard[idx][idy + 2] == xMove) {
                    xi = idx;
                    yi = idy;
                }

                if (gameBoard[idx][idy] == xMove && gameBoard[idx][idy + 1] == 0 && gameBoard[idx][idy + 2] == xMove) {
                    xi = idx;
                    yi = idy + 1;
                }
            }
        }

        //Find 2 X upper to lower
        for (int idx = 0; idx < numberOfButton - 2; idx++) {
            for (int idy = 0; idy < numberOfButton; idy++) {

                if (gameBoard[idx][idy] == xMove && gameBoard[idx + 1][idy] == xMove && gameBoard[idx + 2][idy] == 0) {
                    System.out.println("what1");
                    xi = idx + 2;
                    yi = idy;
                }

                if (gameBoard[idx][idy] == 0 && gameBoard[idx + 1][idy] == xMove && gameBoard[idx + 2][idy] == xMove) {
//                    System.out.println("what2");
                    xi = idx;
                    yi = idy;
                }

                if (gameBoard[idx][idy] == xMove && gameBoard[idx + 1][idy] == 0 && gameBoard[idx + 2][idy] == xMove) {
//                    System.out.println("what2");
                    xi = idx + 1;
                    yi = idy;
                }
            }
        }

        //find 2 X in upperleft ot lower lower right 
        for (int idx = 0; idx < numberOfButton - 2; idx++) {
            for (int idy = 0; idy < numberOfButton - 2; idy++) {
                if (gameBoard[idx][idy] == xMove && gameBoard[idx + 1][idy + 1] == xMove && gameBoard[idx + 2][idy + 2] == 0) {

                    xi = idx + 2;
                    yi = idy + 2;
                }

                if (gameBoard[idx][idy] == 0 && gameBoard[idx + 1][idy + 1] == xMove && gameBoard[idx + 2][idy + 2] == xMove) {
                    xi = idx;
                    yi = idy;
                }

                if (gameBoard[idx][idy] == xMove && gameBoard[idx + 1][idy + 1] == 0 && gameBoard[idx + 2][idy + 2] == xMove) {
                    xi = idx + 1;
                    yi = idy + 1;
                }
            }
        }

        //lowerleft to upper
        for (int idx = 1; idx < numberOfButton - 1; idx++) {
            for (int idy = 1; idy < numberOfButton - 1; idy++) {
                if (gameBoard[idx][idy] == xMove && gameBoard[idx - 1][idy + 1] == xMove && gameBoard[idx + 1][idy - 1] == 0) {
                    System.out.println("Not Found");
                    xi = idx + 1;
                    yi = idy - 1;
                }

                if (gameBoard[idx][idy] == xMove && gameBoard[idx + 1][idy - 1] == xMove && gameBoard[idx - 1][idy + 1] == 0) {
                    xi = idx - 1;
                    yi = idy + 1;
                }

                if (gameBoard[idx][idy] == 0 && gameBoard[idx + 1][idy - 1] == xMove && gameBoard[idx - 1][idy + 1] == xMove) {
                    xi = idx;
                    yi = idy;
                }
            }
        }
        IOX = xi;
        IOY = yi;
    }
    
    /**
     * Checking move finish;
     * @return 
     */

    private boolean isFinishNumberOfMove() {
        return countMove == numberOfButton * numberOfButton;
    }

    
    /**
     * Method for starting X win window
     */
    private void showXWinScreen() {
        GameTicTacToe.screen2 = new XWinScreen();
        GameTicTacToe.screen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen2.setSize(768, 400);
        GameTicTacToe.screen2.setVisible(true);
        GameTicTacToe.screen2.setResizable(false);
    }
    
    /**
     * Method for starting O win window
     */

    private void showOWinScreen() {
        GameTicTacToe.screen2 = new OWinScreen();
        GameTicTacToe.screen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen2.setSize(768, 400);
        GameTicTacToe.screen2.setVisible(true);
        GameTicTacToe.screen2.setResizable(false);

    }
    
    /**
     * Method for starting draw window
     */

    private void showGameDrawScreen() {
        GameTicTacToe.screen2 = new GameDrawScreen();
        GameTicTacToe.screen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameTicTacToe.screen2.setSize(768, 400);
        GameTicTacToe.screen2.setVisible(true);
        GameTicTacToe.screen2.setResizable(false);
    }
    
    /**
     * Method checking winner
     * @param currentX
     * @param currentY
     * @return 
     */

    private boolean gameResultFound(int currentX, int currentY) {

        if (checkLeftToRight(currentX, currentY)) {
            return true;
        }

        if (checkUpperToLower(currentX, currentY)) {
            return true;
        }

        if (checkUpperLeftToLowerRight(currentX, currentY)) {
            return true;
        }

        if (checkUpperRightToLowerLeft(currentX, currentY)) {
            return true;
        }

        return false;
    }
    
    /**
     * Checking is winner found Left to right 
     * @param currentX
     * @param currentY
     * @return 
     */

    private boolean checkLeftToRight(int currentX, int currentY) {
        int initialY;
        int finalY;
        boolean sameThing = false;

        int compareValue = gameBoard[currentX][currentY];

        for (int initial = 1; initial <= XvsX; initial++) {

            initialY = currentY - (XvsX - initial);
            finalY = currentY + initial - 1;

            if (initialY >= 0 && finalY < numberOfButton) {
                sameThing = true;
                clearPath();
                for (int Y = initialY; Y <= finalY; Y++) {
                    savePath(currentX, Y);
                    if (gameBoard[currentX][Y] != compareValue) {
                        sameThing = false;
                        break;
                    }
                }
                if (sameThing) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Checking for winner upper to lower
     * @param currentX
     * @param currentY
     * @return 
     */

    private boolean checkUpperToLower(int currentX, int currentY) {
        int initialX;
        int finalX;
        boolean sameThing = false;
        int compareValue = gameBoard[currentX][currentY];
        for (int initial = 1; initial <= XvsX; initial++) {
            initialX = currentX - (XvsX - initial);
            finalX = currentX + initial - 1;

            if (initialX >= 0 && finalX < numberOfButton) {
                sameThing = true;
                clearPath();
                for (int X = initialX; X <= finalX; X++) {
                    savePath(X, currentY);
                    if (gameBoard[X][currentY] != compareValue) {
                        sameThing = false;
                        break;
                    }
                }

                if (sameThing) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Checking for finding winner  upper left to lower right
     * @param currentX
     * @param currentY
     * @return 
     */

    private boolean checkUpperLeftToLowerRight(int currentX, int currentY) {

        int initialX, initialY;
        int finalX, finalY;
        int X, Y;

        boolean sameThing = false;

        int compareValue = gameBoard[currentX][currentY];

        for (int initial = 1; initial <= XvsX; initial++) {

            initialX = currentX - (XvsX - initial);
            initialY = currentY - (XvsX - initial);
            finalX = currentX + initial - 1;
            finalY = currentY + initial - 1;

            if (initialX >= 0 && initialY >= 0 && finalX < numberOfButton && finalY < numberOfButton) {
                sameThing = true;
                clearPath();
                for (X = initialX, Y = initialY; X <= finalX; X++, Y++) {
                    savePath(X, Y);
                    if (gameBoard[X][Y] != compareValue) {
                        sameThing = false;
                        break;
                    }
                }
            }
            if (sameThing) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checking for possible  winner Upper right to lower left 
     * @param currentX
     * @param currentY
     * @return 
     */

    private boolean checkUpperRightToLowerLeft(int currentX, int currentY) {

        int initialX, initialY;
        int finalX, finalY;
        int X, Y;
        boolean sameThing = false;
        int compareValue = gameBoard[currentX][currentY];
        for (int initial = 1; initial <= XvsX; initial++) {

            initialX = currentX - (XvsX - initial);
            initialY = currentY + (XvsX - initial);
            finalX = currentX + (initial - 1);
            finalY = currentY - (initial - 1);

            if (initialX >= 0 && initialY < numberOfButton && finalX < numberOfButton && finalY >= 0) {
                sameThing = true;
                clearPath();
                for (X = initialX, Y = initialY; X <= finalX; X++, Y--) {
                    savePath(X, Y);
                    if (gameBoard[X][Y] != compareValue) {
                        sameThing = false;
                        break;
                    }
                }
            }
            if (sameThing) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Saving the winner path
     * @param idx
     * @param idy 
     */

    private void savePath(int idx, int idy) {
        winPath.add(new Integer(idx));
        winPath.add(new Integer(idy));
    }
    
    /**
     * Clearing the winner path result
     */

    private void clearPath() {
        winPath.clear();
    }
}
