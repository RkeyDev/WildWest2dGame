package main;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;

import inputs.KeyboardInputs;


public class GameWindow extends JFrame{
    GamePanel gamePanel;
    public GameWindow(GamePanel gamePanel){
        this.gamePanel = gamePanel;
       //setting up the window
       this.setResizable(false);
       this.add(gamePanel);
       this.pack();
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       this.addKeyListener(new KeyboardInputs(gamePanel.player));
       
       this.setVisible(true); //setting the window to be visible

        this.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                //stopping the player from moving when we lose focus on the window 
                gamePanel.OnFocousLoss();

            }
            
        });
    }
}
