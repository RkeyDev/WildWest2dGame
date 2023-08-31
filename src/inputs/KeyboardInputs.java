package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entities.Player;

public class KeyboardInputs implements KeyListener{
    Player player;

    //constructor that initialize the Player object
    public KeyboardInputs(Player Player){
        this.player = Player;
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
                player.setUp(true); //Set the up direction to true
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                player.setLeft(true);//Set the left direction to true


                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                player.setDown(true);//Set the down direction to true
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                player.setRight(true);//Set the right direction to true
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //Handle key releasses
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                player.setUp(false); //Set the up direction to false 
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                player.setLeft(false);//Set the left direction to false
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                player.setDown(false);//Set the down direction to false
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                player.setRight(false);//Set the right direction to false
                break;
        }
    }
    
}
