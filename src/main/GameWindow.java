package main;

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
       this.addKeyListener(new KeyboardInputs(gamePanel));
       
       this.setVisible(true); //setting the window to be visible

    }
}
