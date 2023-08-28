package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener{
    GamePanel gamePanel;

    //constructor that initialize the gamePanel object
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Handle key presses
        switch(e.getKeyCode()){
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                gamePanel.setUp(true); //set the up direction to true
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                gamePanel.setLeft(true);//set the left direction to true
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                gamePanel.setDown(true);//set the down direction to true
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                gamePanel.setRight(true);//set the right direction to true
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Handle key releasses
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                gamePanel.setUp(false); //set the up direction to false 
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                gamePanel.setLeft(false);//set the left direction to false
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                gamePanel.setDown(false);//set the down direction to false
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                gamePanel.setRight(false);//set the right direction to false
                break;
        }
    }
    
}
